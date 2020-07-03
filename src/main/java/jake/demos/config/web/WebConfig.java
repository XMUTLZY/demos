package jake.demos.config.web;

import com.github.pagehelper.PageHelper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.Properties;

/**
 * Created by Jake.lin on 2020/06/30
 */
@Configuration
public class WebConfig {
    @Bean
    public PageHelper pageHelper() {
        PageHelper pageHelper = new PageHelper();
        Properties properties = new Properties();
        // 分页时自动进行count计算
        properties.setProperty("rowBoundsWithCount", "true");
        // 启用参数合理化
        properties.setProperty("reasonable", "true");
        pageHelper.setProperties(properties);
        return pageHelper;
    }

}
