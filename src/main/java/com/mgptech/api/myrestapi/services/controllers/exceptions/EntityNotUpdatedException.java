package com.mgptech.api.myrestapi.services.controllers.exceptions;

public class EntityNotUpdatedException extends RuntimeException{

    public EntityNotUpdatedException(String msg){
        super(msg);
    }
}
