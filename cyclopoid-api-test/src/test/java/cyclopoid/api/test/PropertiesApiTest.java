package cyclopoid.api.test;

import cyclopoid.config.HostConfig;
import cyclopoid.db.DBManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.get;
import static org.hamcrest.Matchers.hasSize;

public class PropertiesApiTest {

    @Test
    public void shouldReturnPropertiesArray() {
        get(HostConfig.getInstance().getBackURL() + "/properties/all")
                .then()
                .body("properties", hasSize(1));
    }

    @BeforeEach
    private void restoreDB() {
        DBManager.restoreDB();
    }
}
