package ua.cyclopoid.back.form;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ua.cyclopoid.back.form.api.FormRepository;
import ua.cyclopoid.back.form.api.FormService;

import java.util.HashMap;
import java.util.Map;

@Controller()
@RequestMapping(path="/form")
public class FormController {

    private final static Logger LOGGER = LoggerFactory.getLogger(FormController.class);

    @Autowired
    public FormService formService;

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Form> getAllForms() {
        return formService.findAll();
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public @ResponseBody Map<String, String> addNewForm(@RequestParam String name) {
        Form form = new Form();
        form.setName(name);
        this.formService.save(form);

        return new HashMap<String,   String>() {{
            put("result", "success");
        }};
    }

}
