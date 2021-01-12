package com.mgptech.api.myrestapi.application.dto.request;

import com.mgptech.api.myrestapi.domain.entities.Usuario;

public class UserAuthenticatedDto {
    private String tipo;
    private String email;
    private String nome;
    private String token;

    public UserAuthenticatedDto(String email, String nome, String token, String tipo) {

        this.email = email;
        this.nome = nome;
        this.token = token;
        this.tipo = tipo;
    }

    public UserAuthenticatedDto(){}

    public static UserAuthenticatedDto toDTO(Usuario user, String tipo) {
        return new UserAuthenticatedDto(user.getEmail(), user.getFirstName(), user.getToken(), tipo);
    }

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public String getToken() {
        return token;
    }

    public String getTipo() {
        return tipo;
    }
}
