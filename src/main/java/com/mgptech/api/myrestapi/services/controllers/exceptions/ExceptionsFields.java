package com.mgptech.api.myrestapi.services.controllers.exceptions;

public class ExceptionsFields {

    private String name;
    private String message;

    public ExceptionsFields(String name, String message) {
        this.name = name;
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
