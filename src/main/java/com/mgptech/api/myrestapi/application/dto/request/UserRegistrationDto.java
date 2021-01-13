package com.mgptech.api.myrestapi.application.dto.request;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.mgptech.api.myrestapi.domain.entities.Usuario;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@JsonAutoDetect(fieldVisibility= JsonAutoDetect.Visibility.ANY)
public class UserRegistrationDto {

    private Long id;

    private String nome;
    @Email
    @NotBlank
    private String email;
    private String senha;

    public UserRegistrationDto() {

    }

    public UserRegistrationDto(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public Usuario toUser() {
        return new Usuario(getNome(), getEmail(), getSenha());
    }


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


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

