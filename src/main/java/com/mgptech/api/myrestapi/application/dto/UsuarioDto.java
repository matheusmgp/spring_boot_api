package com.mgptech.api.myrestapi.application.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mgptech.api.myrestapi.domain.entities.Chamado;
import com.mgptech.api.myrestapi.domain.entities.Usuario;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * UsuarioDto
 */
public class UsuarioDto  extends IdentityDto {


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