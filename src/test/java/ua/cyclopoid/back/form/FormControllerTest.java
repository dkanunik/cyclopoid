package ua.cyclopoid.back.form;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.AnnotationConfigWebContextLoader;
import org.springframework.test.web.servlet.MockMvc;
import ua.cyclopoid.TestConfig;
import ua.cyclopoid.back.db.DBManager;
import ua.cyclopoid.back.db.DataSourceImpl;

import java.util.List;

import static java.util.Collections.singletonList;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.core.Is.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(FormController.class)
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = TestConfig.class, loader = AnnotationConfigWebContextLoader.class)
public class FormControllerTest {

    public static final String RESTORE_FILE = "restore";

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private DataSourceImpl dataSourceImpl;

    @MockBean
    private FormController formController;

    @Test
    public void shouldReturnDefaultMessage() throws Exception {
        Form form = new Form();
        form.setName("feedback");

        List<Form> allForms = singletonList(form);

        given(this.formController.getAllForms()).willReturn(allForms);


        this.mockMvc.perform(get("/form/all")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].name", is(form.getName())));
    }

    @BeforeEach
    public void testInit() {
        DBManager.restoreDB(this.dataSourceImpl, RESTORE_FILE);
    }
}
