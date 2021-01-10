package com.mgptech.api.myrestapi.services.controllers.exceptions;

public class EntityNotFoundException extends RuntimeException {

    public EntityNotFoundException(String msg){
        super(msg);
    }
}
