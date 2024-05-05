package ua.cyclopoid.back.form;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class FormExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {FormNotFoundException.class})
    protected ResponseEntity<Object> handleConflict(FormNotFoundException e, WebRequest request) {

        Map<String, String> responceBody = new HashMap<>();
        responceBody.put("reuslt","error");
        responceBody.put("exception", e.getClass().getName());
        responceBody.put("message", e.getMessage());
        responceBody.put("httpStatusCode", String.valueOf(HttpStatus.NOT_FOUND.value()));
        responceBody.put("httpStatusReason", HttpStatus.NOT_FOUND.getReasonPhrase());

        final HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", MediaType.APPLICATION_JSON_VALUE);

        return handleExceptionInternal(e, responceBody, headers, HttpStatus.NOT_FOUND, request);
    }
}
