package com.mgptech.api.myrestapi.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;

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

    @Column(name = "data_abertura", nullable = false)
    private String dataAbertura;

    @Column(name = "data_fechamento", nullable = true)
    private String dataFechamento;

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
    private Usuario usuario_finish;

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

    public String getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(String dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public String getDataFechamento() {
        return dataFechamento;
    }

    public void setDataFechamento(String dataFechamento) {
        this.dataFechamento = dataFechamento;
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
        return usuario_finish;
    }

    public void setUsuario_finish(Usuario usuario_finish) {
        this.usuario_finish = usuario_finish;
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
