package com.api.api_crud.model.exception;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String mensagen) {
        super(mensagen);
    }
}
