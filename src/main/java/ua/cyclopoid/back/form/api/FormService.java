package ua.cyclopoid.back.form.api;

import org.springframework.stereotype.Component;
import ua.cyclopoid.back.form.Form;

import java.util.List;

@Component("frmService")
public interface FormService {

    Form save(Form form);

    List<Form> findAll();

    Form getFormById(Long formId);
}
