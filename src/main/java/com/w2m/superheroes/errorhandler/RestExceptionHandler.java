package com.w2m.superheroes.errorhandler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.server.ResponseStatusException;

@ControllerAdvice
@Slf4j
public class RestExceptionHandler {

    @ExceptionHandler(Exception.class)
    protected ResponseEntity<Object> handleException(Exception ex) {
        log.error("::: Error {} :::", ex.getMessage());
        return new ResponseEntity<>(new APIError(HttpStatus.INTERNAL_SERVER_ERROR.value()),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ResponseStatusException.class)
    protected ResponseEntity<Object> responseStatusException(ResponseStatusException ex) {
        return new ResponseEntity<>(new APIError(ex.getStatusCode().value(), ex.getReason()), ex.getStatusCode());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<Object> methodArgumentNotValidException(MethodArgumentNotValidException ex) {
        return new ResponseEntity<>(new APIError(HttpStatus.BAD_REQUEST.value(),
                ex.getBindingResult().getFieldErrors().get(0).getDefaultMessage()), HttpStatus.BAD_REQUEST);
    }

}
