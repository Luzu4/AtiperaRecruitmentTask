package com.example.atipera.exceptionHandler;

import com.example.atipera.exceptionHandler.dto.CustomExceptionError;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExceptionHandler
        extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {HttpClientErrorException.class})
    protected ResponseEntity<Object> userNotFound(
            HttpClientErrorException ex, WebRequest request) {
        CustomExceptionError customExceptionError = new CustomExceptionError();
        customExceptionError.setMessage(ex.getStatusText());
        customExceptionError.setStatus(ex.getStatusCode().value());
        return handleExceptionInternal(ex, customExceptionError,
                new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }
}