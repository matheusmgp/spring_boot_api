package com.mgptech.api.myrestapi.application.dto.request;

public class DadosLoginRequest {

    private String email;
    private String senha;

    public DadosLoginRequest() {

    }

    public DadosLoginRequest(String email, String senha) {
        this.email = email;
        this.senha = senha;
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


}
