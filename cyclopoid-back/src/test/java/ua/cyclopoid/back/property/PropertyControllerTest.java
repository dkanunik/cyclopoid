package ua.cyclopoid.back.property;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.AnnotationConfigWebContextLoader;
import org.springframework.test.web.servlet.MockMvc;
import ua.cyclopoid.TestConfig;
import ua.cyclopoid.back.property.api.PropertyRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Collections.singletonList;
import static java.util.Collections.singletonMap;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.core.Is.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PropertyController.class)
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = TestConfig.class, loader = AnnotationConfigWebContextLoader.class)
public class PropertyControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PropertyController propertyController;

    @MockBean
    public PropertyRepository propertyRepository;

    private ObjectMapper mapper = new ObjectMapper();


    @Test
    public void shouldReturnPropertyArray() throws Exception {
        Property expectedProperty = new Property();

        Map<String, List<Property>> expectedResponceBody = singletonMap("properties", singletonList(expectedProperty));

        given(this.propertyController.getAllProperties()).willReturn(expectedResponceBody);

        this.mockMvc.perform(
                get("/property/all")
                        .contentType(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.properties[*]", hasSize(1)));
    }

    @Test
    public void shouldCreateNewProperty() throws Exception {
        Map<String, String> responceBody = new HashMap<>();
        responceBody.put("httpStatusCode", "201");
        responceBody.put("result", "success");
        responceBody.put("id", "1");

        given(this.propertyController.addNewProperty(any())).willReturn(responceBody);

        this.mockMvc.perform(
                post("/property/add")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .characterEncoding("utf-8")
                        .content("{\"propertyName\":\"username\",\"formId\":\"1\"}"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.httpStatusCode", is("201")))
                .andExpect(jsonPath("$.result", is("success")))
                .andExpect(jsonPath("$.id", is("1")));
    }
}
