package com.mgptech.api.myrestapi.services.controllers.exceptions;

public class EntityNotCreatedException extends RuntimeException {
    public EntityNotCreatedException(String msg) {
        super(msg);
    }
}
