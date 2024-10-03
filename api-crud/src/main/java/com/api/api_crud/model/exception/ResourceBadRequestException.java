package com.api.api_crud.model.exception;

public class ResourceBadRequestException extends RuntimeException {
    public ResourceBadRequestException(String mensagen) {
        super(mensagen);
    }
}
