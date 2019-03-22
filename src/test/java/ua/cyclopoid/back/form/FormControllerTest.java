package ua.cyclopoid.back.form;


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

import java.util.List;
import java.util.Map;

import static java.util.Collections.singletonList;
import static java.util.Collections.singletonMap;
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

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FormController formController;

    @Test
    public void shouldReturnFormArray() throws Exception {
        Form expectedForm = new Form();
        expectedForm.setName("feedback");

        Map<String, List<Form>> expectedResponceBody = singletonMap("forms", singletonList(expectedForm));

        given(this.formController.getAllForms()).willReturn(expectedResponceBody);

        this.mockMvc.perform(
                get("/form/all")
                        .contentType(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.forms[*]", hasSize(1)));
    }

    @Test
    public void shouldReturnFormById() throws Exception {
        Form expectedForm = new Form();
        expectedForm.setName("feedback");
        expectedForm.setId(1L);

        Map<String, Form> expectedResponceBody = singletonMap("form", expectedForm);

        given(this.formController.getFormById("1")).willReturn(expectedResponceBody);

        this.mockMvc.perform(
                get("/form/by/id/1")
                        .contentType(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.form.id", is(expectedForm.getId().intValue())))
                .andExpect(jsonPath("$.form.name", is(expectedForm.getName())));
    }
}
