package com.w2m.superheroes.exception;

public class ValidationException extends RuntimeException {

    private static final long serialVersionUID = -8017748944528911357L;

    public ValidationException(String error) {
        super(error);
    }

}
