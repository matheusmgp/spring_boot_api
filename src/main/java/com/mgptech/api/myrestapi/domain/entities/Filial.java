package com.mgptech.api.myrestapi.domain.entities;

import java.io.Serializable;
import java.util.Date;
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
@JsonIgnoreProperties(ignoreUnknown=true)
public class Filial extends BaseEntity implements Serializable{


	@Column(name = "nome_fantasia", nullable = false)
    private String fantasia;

    @Column(name = "razao_social", nullable = false)
    private String razao;

    @Column(name = "cnpj", nullable = false)
    private String cnpj;

    @Column(name = "status", nullable = false)
    private Boolean status;

    @Column(name = "mac", nullable = true)
    private String mac;

    @Column(name = "dia_vencimento", nullable = true)
    private Integer diaVencimento;

    @Basic
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_bloqueio", nullable = false)
    private java.util.Date dataBloqueio;

    @Basic
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_expiracao", nullable = false)
    private java.util.Date dataExpiracao;

    @Basic
    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Date updatedAt;

    @Basic
    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Date createdAt;


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


    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public Integer getDiaVencimento() {
        return diaVencimento;
    }

    public void setDiaVencimento(Integer diaVencimento) {
        this.diaVencimento = diaVencimento;
    }

    public Date getDataBloqueio() {
        return dataBloqueio;
    }

    public void setDataBloqueio(Date dataBloqueio) {
        this.dataBloqueio = dataBloqueio;
    }

    public Date getDataExpiracao() {
        return dataExpiracao;
    }

    public void setDataExpiracao(Date dataExpiracao) {
        this.dataExpiracao = dataExpiracao;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}