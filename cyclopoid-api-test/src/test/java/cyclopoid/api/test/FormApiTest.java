package cyclopoid.api.test;

import cyclopoid.config.HostConfig;
import cyclopoid.db.DBManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.get;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;

public class FormApiTest {

    @Test
    public void shouldReturnFormArray() {
        get(HostConfig.getInstance().getBackURL() + "/form/all")
                .then()
                .body("forms", hasSize(1));
    }

    @Test
    public void shouldReturnFormById() {
        get(HostConfig.getInstance().getBackURL() + "/form/by/id/1")
                .then()
                .body("form.id", is(1))
                .body("form.name", is("feedback"));
    }

    @BeforeEach
    private void restoreDB() {
        DBManager.restoreDB();
    }

}
