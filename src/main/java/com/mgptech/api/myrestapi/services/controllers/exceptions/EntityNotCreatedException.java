package com.mgptech.api.myrestapi.services.controllers.exceptions;

import java.time.LocalDateTime;
import java.util.List;

public class EntityNotCreatedException extends RuntimeException {

    private Integer status;
    private LocalDateTime dataHora;
    private String titulo;
    private List<ExceptionsFields> fields;

    public EntityNotCreatedException(String msg) {
        super(msg);
    }
    public EntityNotCreatedException(Integer status,LocalDateTime dataHora,String titulo) {
        this.status = status;
        this.dataHora = dataHora;
        this.titulo = titulo;
    }

    public List<ExceptionsFields> getFields() {
        return fields;
    }

    public void setFields(List<ExceptionsFields> fields) {
        this.fields = fields;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}
