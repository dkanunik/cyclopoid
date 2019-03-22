package ua.cyclopoid.back.form;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ua.cyclopoid.back.form.api.FormService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller()
@RequestMapping(path = "/form")
@CrossOrigin("*")
public class FormController {

    private static final Logger LOGGER = LoggerFactory.getLogger(FormController.class);

    @Autowired
    @Qualifier("formServiceImpl")
    public FormService formService;

    @GetMapping(path = "/all")
    public @ResponseBody
    Map<String, List<Form>> getAllForms() {
        HashMap<String, List<Form>> responce = new HashMap<>();
        responce.put("forms", this.formService.findAll());

        LOGGER.debug("return all forms");

        return responce;
    }

    @PostMapping(value = "/add")
    public @ResponseBody
    Map<String, String> addNewForm(@RequestBody Map<String, String> request) {
        Form form = new Form();
        form.setName(request.get("formName"));
        this.formService.save(form);

        Map<String, String> responceBody = new HashMap<>();
        responceBody.put("result", "success");

        LOGGER.debug("add new form {}", form);

        return responceBody;
    }

    @GetMapping(value = "/by/id/{id}")
    public @ResponseBody
    Map<String, Form> getFormById(@PathVariable("id") String id) {
        Long formId;
        try {
            formId = new Long(id);
        } catch (NumberFormatException e) {
            throw new FormNotFoundException("Invalid form id: " + id);
        }
        HashMap<String, Form> responce = new HashMap<>();
        responce.put("form", this.formService.getFormById(formId));

        LOGGER.debug("form by id: {}", id);

        return responce;
    }
}
