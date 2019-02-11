package ua.cyclopoid.back.form;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller()
@RequestMapping(path="/form")
public class FormController {

    @Autowired
    public FormRepository formRepository;

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Form> getAllForms() {
        return formRepository.findAll();
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public @ResponseBody Map<String, String> addNewForm(@RequestParam String name) {
        Form form = new Form();
        form.setName(name);
        formRepository.save(form);

        return new HashMap<String,   String>() {{
            put("result", "success");
        }};
    }

}
