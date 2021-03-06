package com.mgptech.api.myrestapi.domain.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import java.io.Serializable;
import org.springframework.stereotype.Component;
/**
 * Categoria
 */

@Entity
@Component
@Table(name = "categoria")
public class Categoria extends BaseEntity implements Serializable{



    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "status", nullable = false)
    private Boolean status;

    public Boolean getStatus() {
        return status;
    }
    public void setStatus(Boolean status) {
        this.status = status;
    }
    public String getNome() {
    	return this.nome;
    }
    public void setNome(String nome) {
    	this.nome = nome;
    }  

}