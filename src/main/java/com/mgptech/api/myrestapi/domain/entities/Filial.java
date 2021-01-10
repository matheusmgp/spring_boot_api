package com.mgptech.api.myrestapi.domain.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.stereotype.Component;

/**
 * Filial
 */
@Entity
@Component
@Table(name = "filial")
public class Filial extends BaseEntity implements Serializable{


	@Column(name = "nome_fantasia", nullable = false)
    private String fantasia;

    @Column(name = "razao_social", nullable = false)
    private String razao;

    @Column(name = "cnpj", nullable = false)
    private String cnpj;

    @JsonManagedReference
    @OneToMany(mappedBy = "filial")
    private List<Chamado> chamados;

    public List<Chamado> getChamado() {
        return chamados;
    }
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