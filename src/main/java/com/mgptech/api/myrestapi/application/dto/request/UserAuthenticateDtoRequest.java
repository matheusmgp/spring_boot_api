package com.mgptech.api.myrestapi.application.dto.request;

import com.mgptech.api.myrestapi.domain.entities.Usuario;

public class UserAuthenticateDtoRequest {
    private String tipo;
    private String email;
    private String nome;
    private String token;

    public UserAuthenticateDtoRequest(String email, String nome, String token, String tipo) {

        this.email = email;
        this.nome = nome;
        this.token = token;
        this.tipo = tipo;
    }

    public UserAuthenticateDtoRequest(){}

    public static UserAuthenticateDtoRequest toDTO(Usuario user, String tipo) {
        return new UserAuthenticateDtoRequest(user.getEmail(), user.getNome(), user.getToken(), tipo);
    }
    public static UserAuthenticateDtoRequest toDTO(UsuarioDtoRequest user, String tipo) {
        return new UserAuthenticateDtoRequest(user.getEmail(), user.getNome(), user.getToken(), tipo);
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
