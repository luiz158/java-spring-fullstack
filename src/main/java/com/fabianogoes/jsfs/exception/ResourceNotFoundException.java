package com.fabianogoes.jsfs.exception;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String id) {
        super(String.format("Resource id[%s] not found!", id));
    }

}
