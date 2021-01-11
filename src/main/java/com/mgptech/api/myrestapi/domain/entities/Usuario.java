package com.mgptech.api.myrestapi.domain.entities;
import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.stereotype.Component;

/**
 * Usuario
 */
@Entity
@Component
@Table(name = "usuario")
@JsonIgnoreProperties(ignoreUnknown=true)
public class Usuario extends BaseEntity implements Serializable{

	@Column(name = "first_name", nullable = false)
    private String firstName;    

    @Column(name = "last_name", nullable = false)
    private String lastName;

    private Boolean acesso;
    @JsonManagedReference
    @OneToMany(mappedBy = "usuario")
    private List<Chamado> chamados;

    @JsonManagedReference
    @OneToMany(mappedBy = "usuario")
    private List<Pendencia> pendencias;



    public List<Pendencia> getPendencias() {
        return pendencias;
    }

    public List<Chamado> getChamados() {
        return chamados;
    }

    public void setChamados(List<Chamado> chamados) {
        this.chamados = chamados;
    }

    public void setPendencias(List<Pendencia> pendencias) {
        this.pendencias = pendencias;
    }

    public List<Chamado> getChamado() {
        return chamados;
    }
    public String getFirstName() {
    	return this.firstName;
    }
    public void setFirstName(String firstName) {
    	this.firstName = firstName;
    }
  
    public String getLastName() {
    	return this.lastName;
    }
    public void setLastName(String lastName) {
    	this.lastName = lastName;
    }


    public Boolean getAcesso() {
    	return this.acesso;
    }
    public void setAcesso(Boolean acesso) {
    	this.acesso = acesso;
    }

    
}