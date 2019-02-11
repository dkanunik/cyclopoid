package ua.cyclopoid.back.form;

public class FormNotFoundException extends RuntimeException {

    public FormNotFoundException(Long id) {
        super("Could not find form " + id);
    }
}
