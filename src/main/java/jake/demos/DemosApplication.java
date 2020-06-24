package jake.demos;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@MapperScan("jake.demos.repository")
public class DemosApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemosApplication.class, args);
    }

}
