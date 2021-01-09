package com.mgptech.api.myrestapi.domain.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

/**
 * Filial
 */
@Entity
@Component
@Table(name = "filial")
public class Filial extends BaseEntity implements Serializable{

	/*@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    protected long id;*/

	@Column(name = "nome_fantasia", nullable = false)
    private String fantasia;

    @Column(name = "razao_social", nullable = false)
    private String razao;

    @Column(name = "cnpj", nullable = false)
    private String cnpj;


    /*public Long getId() {
    	return this.id;
    }
    public void setId(Long id) {
    	this.id = id;
    }*/

    public String getFantasia() {
    	return this.fantasia;
    }
    public void setFantasia(String fantasia) {
    	this.fantasia = fantasia;
    }



    public String getRazao() {
    	return this.razao;
    }
    public void setRazao(String razao) {
    	this.razao = razao;
    }

    public String getCnpj() {
    	return this.cnpj;
    }
    public void setCnpj(String cnpj) {
    	this.cnpj = cnpj;
    }

  
    
}