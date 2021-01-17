package com.mgptech.api.myrestapi.application.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mgptech.api.myrestapi.application.dto.IdentityDto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;


public class FilialEnderecoDtoRequest extends IdentityDto {


    @JsonProperty(defaultValue = "logradouro")
    @NotBlank(message = "logradouro é obrigatório.")
    private String logradouro;
    @JsonProperty(defaultValue = "cidade")
    @NotBlank(message = "cidade é obrigatório.")
    private String cidade;
    @JsonProperty(defaultValue = "bairro")
    @NotBlank(message = "bairro é obrigatório.")
    private String bairro;
    @JsonProperty(defaultValue = "cep")
    @NotBlank(message = "cep é obrigatório.")
    private String cep;
    @JsonProperty(defaultValue = "numero")
    @NotBlank(message = "numero é obrigatório.")
    private String numero;
    @JsonProperty(defaultValue = "complemento")
    private String complemento;
    @JsonProperty(defaultValue = "uf")
    @NotBlank(message = "uf é obrigatório.")
    private String uf;



    public String getLogradouto() {
        return logradouro;
    }

    public void setLogradouto(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }
}
