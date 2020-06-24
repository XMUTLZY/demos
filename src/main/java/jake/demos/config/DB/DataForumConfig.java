package jake.demos.config.DB;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Jake.lin on 2020/06/24
 */
@Configuration
public class DataForumConfig {
    @Value("${spring.datasource.forum.url}")
    private String url;
    @Value("${spring.datasource.forum.userName}")
    private String userName;
    @Value("${spring.datasource.forum.password}")
    private String password;
    @Value("${spring.datasource.forum.driverClassName}")
    private String driverClassName;

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
