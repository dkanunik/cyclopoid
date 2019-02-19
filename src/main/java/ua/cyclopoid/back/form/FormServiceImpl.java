package ua.cyclopoid.back.form;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.cyclopoid.back.form.api.FormRepository;
import ua.cyclopoid.back.form.api.FormService;

import java.util.List;

@Service
public class FormServiceImpl implements FormService {

    @Autowired
    private FormRepository formRepository;

    @Override
    public Form save(Form form) {
        return this.formRepository.save(form);
    }

    @Override
    public List<Form> findAll() {
        return this.formRepository.findAll();
    }
}
