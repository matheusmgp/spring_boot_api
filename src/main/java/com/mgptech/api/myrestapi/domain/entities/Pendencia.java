package com.mgptech.api.myrestapi.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Component
@Table(name ="pendencia")
public class Pendencia  extends BaseEntity implements Serializable {

    @Column(name = "descricao", nullable = false)
    private String descricao;

    @Column(name = "solucao", nullable = true)
    private String solucao;

    @Column(name = "status", nullable = false)
    private Boolean status;

    @Basic
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_abertura", nullable = false)
    private java.util.Date dataAbertura;

    @Basic
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_fechamento", nullable = true)
    private java.util.Date dataFechamento;

    @ManyToOne()
    @JsonIgnore
    @JsonIgnoreProperties(ignoreUnknown=true)
    @JoinColumn(name = "chamado_id")
    private Chamado chamado;

    @ManyToOne()
    @JsonIgnore
    @JsonIgnoreProperties(ignoreUnknown=true)
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @ManyToOne()
    @JsonIgnore
    @JsonIgnoreProperties(ignoreUnknown=true)
    @JoinColumn(name = "usuario_id_finish")
    private Usuario usuario_id_finish;

    @ManyToOne()
    @JsonIgnore
    @JsonIgnoreProperties(ignoreUnknown=true)
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    @ManyToOne()
    @JsonIgnore
    @JsonIgnoreProperties(ignoreUnknown=true)
    @JoinColumn(name = "subCategoria_id")
    private SubCategoria subCategoria;

    @ManyToOne()
    @JsonIgnore
    @JsonIgnoreProperties(ignoreUnknown=true)
    @JoinColumn(name = "canal_id")
    private Canais canal;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getSolucao() {
        return solucao;
    }

    public void setSolucao(String solucao) {
        this.solucao = solucao;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Date getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(Date dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public Date getDataFechamento() {
        return dataFechamento;
    }

    public void setDataFechamento(Date dataFechamento) {
        this.dataFechamento = dataFechamento;
    }

    public Usuario getUsuario_id_finish() {
        return usuario_id_finish;
    }

    public void setUsuario_id_finish(Usuario usuario_id_finish) {
        this.usuario_id_finish = usuario_id_finish;
    }

    public Chamado getChamado() {
        return chamado;
    }

    public void setChamado(Chamado chamado) {
        this.chamado = chamado;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getUsuario_finish() {
        return usuario_id_finish;
    }

    public void setUsuario_finish(Usuario usuario_id_finish) {
        this.usuario_id_finish = usuario_id_finish;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public SubCategoria getSubCategoria() {
        return subCategoria;
    }

    public void setSubCategoria(SubCategoria subCategoria) {
        this.subCategoria = subCategoria;
    }

    public Canais getCanal() {
        return canal;
    }

    public void setCanal(Canais canal) {
        this.canal = canal;
    }
}
