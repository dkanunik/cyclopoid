package ua.cyclopoid.back.property;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ua.cyclopoid.back.form.Form;
import ua.cyclopoid.back.form.FormNotFoundException;
import ua.cyclopoid.back.property.api.PropertyService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller()
@RequestMapping(path = "/property")
@CrossOrigin("*")
public class PropertyController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PropertyController.class);

    @Autowired
    @Qualifier("propertyServiceImpl")
    public PropertyService propertyService;

    @GetMapping(path = "/all")
    public @ResponseBody
    Map<String, List<Property>> getAllProperties() {
        HashMap<String, List<Property>> responce = new HashMap<>();
        responce.put("property", this.propertyService.findAll());

        LOGGER.debug("return all properties");

        return responce;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/add", consumes = "application/json", produces = "application/json")
    public @ResponseBody Map<String, String> addNewProperty(@RequestBody Map<String, String> request) {
        Property property = new Property();
        String propertyName = request.get("propertyName");
        property.setName(propertyName);

        Form form = getForm(request.get("formId"));
        property.setForm(form);
        form.addProperty(property);

        Property resultProperty = this.propertyService.save(property);

        HashMap<String, String> responceBody = new HashMap<>();
        responceBody.put("result","success");
        responceBody.put("httpStatusCode", String.valueOf(HttpStatus.OK.value()));
        responceBody.put("propertyId", resultProperty.getId().toString());

        LOGGER.debug("add new property {}", resultProperty);

        return responceBody;
    }

    private Form getForm(String sId) {
        Long formId;
        try {
            formId = new Long(sId);
        } catch (NumberFormatException e) {
            throw new FormNotFoundException("Invalid form id: " + sId);
        }

        Form form = new Form();
        form.setId(formId);

        return form;
    }
}
