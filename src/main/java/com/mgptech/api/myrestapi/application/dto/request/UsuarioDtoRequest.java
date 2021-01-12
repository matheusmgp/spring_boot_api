package com.mgptech.api.myrestapi.application.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mgptech.api.myrestapi.application.dto.IdentityDto;

import javax.persistence.Column;
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

    @JsonProperty(defaultValue = "email")
    @NotBlank(message = "email é obrigatório.")
    private String email;
    @JsonProperty(defaultValue = "senha")
    @NotBlank(message = "senha é obrigatório.")
    private String senha;

    @JsonProperty(defaultValue = "token")
    private String token;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

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