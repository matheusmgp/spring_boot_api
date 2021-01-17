package com.mgptech.api.myrestapi.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Component
@Table(name = "filial_endereco")
@JsonIgnoreProperties(ignoreUnknown=true)
public class FilialEndereco  extends  BaseEntity implements Serializable {

    @Column(name = "logradouro", nullable = false)
    private String logradouro;
    @Column(name = "cidade", nullable = false)
    private String cidade;
    @Column(name = "bairro", nullable = false)
    private String bairro;
    @Column(name = "cep", nullable = false)
    private String cep;
    @Column(name = "numero", nullable = false)
    private String numero;
    @Column(name = "complemento", nullable = true)
    private String complemento;
    @Column(name = "uf", nullable = false)
    private String uf;


    @OneToOne(mappedBy = "filialEndereco")
    private Filial filial;

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
