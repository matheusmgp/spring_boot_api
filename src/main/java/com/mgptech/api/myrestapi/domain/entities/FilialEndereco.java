package com.mgptech.api.myrestapi.domain.entities;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class FilialEndereco  extends  BaseEntity{

    @Column(name = "logradouto", nullable = false)
    private String logradouto;
    @Column(name = "cidade", nullable = false)
    private String cidade;
    @Column(name = "bairro", nullable = false)
    private String bairro;
    @Column(name = "cep", nullable = false)
    private String cep;
    @Column(name = "numero", nullable = false)
    private String numero;
    @Column(name = "complemento", nullable = false)
    private String complemento;
    @Column(name = "uf", nullable = false)
    private String uf;

    public String getLogradouto() {
        return logradouto;
    }

    public void setLogradouto(String logradouto) {
        this.logradouto = logradouto;
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
