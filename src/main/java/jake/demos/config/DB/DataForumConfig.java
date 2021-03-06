package jake.demos.config.DB;

import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import javax.sql.DataSource;
import java.io.IOException;

/**
 * Created by Jake.lin on 2020/06/24
 */
@Configuration
@MapperScan(basePackages = {"jake.demos.repository.forum"}, sqlSessionTemplateRef = "forumSqlSessionTemplate")
public class DataForumConfig {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Value("${spring.datasource.forum.url}")
    private String url;
    @Value("${spring.datasource.forum.userName}")
    private String userName;
    @Value("${spring.datasource.forum.password}")
    private String password;
    @Value("${spring.datasource.forum.driverClassName}")
    private String driverClassName;

    // 设置forum数据库参数
    @Bean(name = "forumDataSource")
    public DataSource forumDataSource() {
        HikariDataSource hikariDataSource = new HikariDataSource();
        hikariDataSource.setJdbcUrl(url);
        hikariDataSource.setUsername(userName);
        hikariDataSource.setPassword(password);
        hikariDataSource.setDriverClassName(driverClassName);
        return hikariDataSource;
    }

    // init sqlSessionFactory
    @Bean
    public SqlSessionFactory forumSqlSessionFactory(@Qualifier("forumDataSource") DataSource dataSource) {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        try {
            sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath:mapper/forum/*.xml"));
        } catch (IOException e) {
            logger.error("SqlSessionFactory forumDataSource init failed");
            e.printStackTrace();
        }
        try {
            return sqlSessionFactoryBean.getObject();
        } catch (Exception e) {
            logger.error("SqlSessionFactory forumDataSource init failed");
            e.printStackTrace();
        }
        return null;
    }

    @Bean
    public SqlSessionTemplate forumSqlSessionTemplate(@Qualifier("forumSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDriverClassName() {
        return driverClassName;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }
}
