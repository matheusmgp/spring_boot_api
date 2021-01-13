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
    private String nome;
    @JsonProperty(defaultValue = "email")
    @NotBlank(message = "email é obrigatório.")
    private String email;
    @JsonProperty(defaultValue = "token")
    private String token;
    @JsonProperty(defaultValue = "senha")
    @NotBlank(message = "senha é obrigatório.")
    private String senha;
    @JsonProperty(defaultValue = "senha")
    @NotBlank(message = "role é obrigatório.")
    private Long role;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

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

    public Long getRole() {
        return role;
    }

    public void setRole(Long role) {
        this.role = role;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}