package ua.cyclopoid.back.db;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import ua.cyclopoid.back.db.api.DataSource;

@Data
@Component
@PropertySource("classpath:db.properties")
@ConfigurationProperties(prefix = "datasource")
public class DataSourceImpl implements DataSource {

    private String url;
    private String userName;
    private String password;
    private String dbName;

}

