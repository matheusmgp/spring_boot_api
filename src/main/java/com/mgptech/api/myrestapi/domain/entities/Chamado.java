package com.mgptech.api.myrestapi.domain.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.stereotype.Component;

/**
 * Chamado
 */

 @Entity
 @Component
 @Table(name = "chamado")
 @JsonIgnoreProperties(ignoreUnknown=true)
public class Chamado extends BaseEntity implements Serializable{


    @Column(name = "protocolo", nullable = false)
    private String protocolo;
    @Basic
    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Date dataAbertura;
    @Basic
    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Date dataFechamento;
    @Column(name = "status", nullable = false)
    private Boolean status;
    @ManyToOne()
    @JsonIgnore
    @JsonIgnoreProperties(ignoreUnknown=true)
    @JoinColumn(name = "filial_id")
    private Filial filial;
    @ManyToOne()
    @JsonIgnore
    @JsonIgnoreProperties(ignoreUnknown=true)
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
    @ManyToOne()
    @JsonIgnore
    @JsonIgnoreProperties(ignoreUnknown=true)
    @JoinColumn(name = "usuario_id_finish")
    private Usuario usuario_finish;
    @ManyToOne()
    @JsonIgnore
    @JsonIgnoreProperties(ignoreUnknown=true)
    @JoinColumn(name = "usuario_id_redirect")
    private Usuario usuario_redirect;
    @ManyToOne()
    @JsonIgnore
    @JsonIgnoreProperties(ignoreUnknown=true)
    @JoinColumn(name = "setor_id")
    private Setor setor;
    @JsonManagedReference
    @OneToMany(mappedBy = "chamado")
    private List<Pendencia> pendencias;

    public List<Pendencia> getPendencias() {
        return pendencias;
    }

    public void setPendencias(List<Pendencia> pendencias) {
        this.pendencias = pendencias;
    }


    public Setor getSetor() {
        return setor;
    }

    public void setSetor(Setor setor) {
        this.setor = setor;
    }

    public String getProtocolo() {
    	return this.protocolo;
    }
    public void setProtocolo(String protocolo) {
    	this.protocolo = protocolo;
    }


    public Date getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(Date dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public Date getDataFechamento() {
    	return this.dataFechamento;
    }
    public void setDataFechamento(Date dataFechamento) {
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

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Usuario getUsuario_finish() {
        return usuario_finish;
    }

    public void setUsuario_finish(Usuario usuario_finish) {
        this.usuario_finish = usuario_finish;
    }

    public Usuario getUsuario_redirect() {
        return usuario_redirect;
    }

    public void setUsuario_redirect(Usuario usuario_redirect) {
        this.usuario_redirect = usuario_redirect;
    }
}