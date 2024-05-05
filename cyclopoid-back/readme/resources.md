### Resources notes

```
File file = new ClassPathResource(fileName).getFile();
# file.getAbsolutePath() ==> PROJECT_DIR/build/resources/test/dump/<fileName>
```

```
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
```