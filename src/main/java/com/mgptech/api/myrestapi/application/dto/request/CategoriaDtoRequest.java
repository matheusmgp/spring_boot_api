package com.mgptech.api.myrestapi.application.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mgptech.api.myrestapi.application.dto.IdentityDto;

import javax.validation.constraints.*;

/**
 * CategoriaDto
 */
public class CategoriaDtoRequest extends IdentityDto {


    @JsonProperty(defaultValue = "nome")
    @NotBlank(message = "Nome é obrigatório.")
    @NotNull
    @Size(min=2, max=35)
    private String nome;

    @JsonProperty(defaultValue = "status")
    @NotNull
    private Boolean status;

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getNome() {
    	return this.nome;
    }
    public void setNome(String nome) {
    	this.nome = nome;
    }  

}