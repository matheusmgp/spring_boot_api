package com.mgptech.api.myrestapi.application.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * UsuarioDto
 */
public class UsuarioDto extends IdentityDto{

    @JsonProperty(defaultValue = "firstName")
    //@NotBlank(message = "Nome é requerido")
    private String firstName;
    
    @JsonProperty(defaultValue = "lastName")
    //@NotBlank(message = "Sobrenome é requerido")
    private String lastName;
   
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