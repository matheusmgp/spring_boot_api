package com.mgptech.api.myrestapi.application.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mgptech.api.myrestapi.application.dto.IdentityDto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * UsuarioDto
 */
public class UsuarioDtoRequest extends IdentityDto {


    @JsonProperty(defaultValue = "firstName")
    @NotBlank(message = "Nome é obrigatório.")
    @Size(min=2, max=14)
    private String firstName;
    
    @JsonProperty(defaultValue = "lastName")
    @NotBlank(message = "SobreNome é obrigatório.")
    @Size(min=2, max=14)
    private String lastName;

    @JsonProperty(defaultValue = "acesso")
    private Boolean acesso;


    public String getFirstName() {
    	return this.firstName;
    }
    public void setFirstName(String firstName) {
    	this.firstName = firstName;
    }


    public String getLastName() {
    	return this.lastName;
    }
    public void setLastName(String lastName) {
    	this.lastName = lastName;
    }


    public Boolean getAcesso() {
    	return this.acesso;
    }
    public void setAcesso(Boolean acesso) {
    	this.acesso = acesso;
    }

}