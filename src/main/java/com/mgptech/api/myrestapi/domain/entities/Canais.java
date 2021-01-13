package com.mgptech.api.myrestapi.domain.entities;

import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Component
@Table(name = "canais")
public class Canais  extends  BaseEntity implements Serializable {


    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "status", nullable = false)
    private Boolean status;

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public Boolean getStatus() {
        return status;
    }
    public void setStatus(Boolean status) {
        this.status = status;
    }


}
