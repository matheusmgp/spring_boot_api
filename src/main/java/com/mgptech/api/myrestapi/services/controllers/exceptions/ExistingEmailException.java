package com.mgptech.api.myrestapi.services.controllers.exceptions;

public class ExistingEmailException  extends RuntimeException{
    public ExistingEmailException(String msg){
        super(msg);
    }

}
