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
@MapperScan(basePackages = {"jake.demos.repository.shop"}, sqlSessionTemplateRef = "shopSqlSessionTemplate")
public class DataShopConfig {
    private Logger logger =  LoggerFactory.getLogger(getClass());

    @Value("${spring.datasource.shop.url}")
    private String url;
    @Value("${spring.datasource.shop.userName}")
    private String userName;
    @Value("${spring.datasource.shop.password}")
    private String password;
    @Value("${spring.datasource.shop.driverClassName}")
    private String driverClassName;

    // 数据源
    @Bean(name = "shopDataSource")
    public DataSource shopDataSource() {
        HikariDataSource hikariDataSource = new HikariDataSource();
        hikariDataSource.setPassword(password);
        hikariDataSource.setDriverClassName(driverClassName);
        hikariDataSource.setJdbcUrl(url);
        hikariDataSource.setUsername(userName);
        return hikariDataSource;
    }

    @Bean
    public SqlSessionFactory shopSqlSessionFactory(@Qualifier("shopDataSource") DataSource dataSource) {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        try {
            sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath:mapper/shop/*.xml"));
        } catch (IOException e) {
            e.printStackTrace();
            logger.error("SqlSessionFactory shopDataSource init failed");
        }
        try {
            return sqlSessionFactoryBean.getObject();
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("SqlSessionFactory shopDataSource init failed");
        }
        return null;
    }

    @Bean
    public SqlSessionTemplate shopSqlSessionTemplate(@Qualifier("shopSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
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
