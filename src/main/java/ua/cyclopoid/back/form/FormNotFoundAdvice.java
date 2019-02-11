package ua.cyclopoid.back.form;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice()
public class FormNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(FormNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String formNotFoundHandler(FormNotFoundException ex) {
        return ex.getMessage();
    }
}
