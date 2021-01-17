package com.mgptech.api.myrestapi.domain.entities;

import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Component
@Table(name = "clinte")
public class Cliente extends  BaseEntity {

    @Column(name = "nome", nullable = false)
    private String nome;
    @Column(name = "cpf", nullable = false,unique=true)
    private String cpf;

    @Column(name = "status", nullable = false)
    private Boolean status;

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
