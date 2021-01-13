package com.mgptech.api.myrestapi.domain.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Role extends  BaseEntity{

    @Column(name = "nome", nullable = false)
    private String nome;
    @Column(name = "status", nullable = false)
    private Boolean status;
    @Basic
    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Date createdAt;
    @Basic
    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Date updatedAt;

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

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}
