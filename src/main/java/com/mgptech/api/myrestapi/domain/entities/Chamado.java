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
 * Chamado
 */

 @Entity
 @Component
 @Table(name = "chamado")
public class Chamado extends BaseEntity implements Serializable{


	@Column(name = "protocolo", nullable = false)
    private String protocolo;

    @Column(name = "data_abertura", nullable = false)
    private String dataAbertura;

    @Column(name = "data_fechamento", nullable = true)
    private String dataFechamento;

    
    private Filial filial;

    private Usuario usuario;

    public String getProtocolo() {
    	return this.protocolo;
    }
    public void setProtocolo(String protocolo) {
    	this.protocolo = protocolo;
    }  

    public String getDataAbertura() {
    	return this.dataAbertura;
    }
    public void setDataAbertura(String dataAbertura) {
    	this.dataAbertura = dataAbertura;
    }
  
    public String getDataFechamento() {
    	return this.dataFechamento;
    }
    public void setDataFechamento(String dataFechamento) {
    	this.dataFechamento = dataFechamento;
    }

    public Filial getFilial() {
    	return this.filial;
    }
    public void setFilial(Filial filial) {
    	this.filial = filial;
    }

    public Usuario getUsuario() {
    	return this.usuario;
    }
    public void setUsuario(Usuario usuario) {
    	this.usuario = usuario;
    }


  
    
}