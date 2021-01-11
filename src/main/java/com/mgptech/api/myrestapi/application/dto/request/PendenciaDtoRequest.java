package com.mgptech.api.myrestapi.application.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mgptech.api.myrestapi.application.dto.IdentityDto;

import javax.persistence.Basic;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.Date;

public class PendenciaDtoRequest extends IdentityDto {

    @JsonProperty(defaultValue = "descricao")
    @NotBlank(message = "Nome fantasia é obrigatório.")
    @Min(value = 8, message = "Nome fantasia não pode ser menor que 8.")
    @Max(value = 40, message = "Nome fantasia não pode ser maior que 40.")
    private String descricao;

    @JsonProperty(defaultValue = "solucao")
    @Max(value = 300, message = "Solução não pode ser maior que 300.")
    private String solucao;

    @JsonProperty(defaultValue = "status")
    private Boolean status;

    @Basic
    @Temporal(TemporalType.TIMESTAMP)
    @JsonProperty(defaultValue = "dataAbertura")
    private java.util.Date dataAbertura;

    @Basic
    @Temporal(TemporalType.TIMESTAMP)
    @JsonProperty(defaultValue = "dataFechamento")
    private java.util.Date dataFechamento;

    @JsonProperty(defaultValue = "usuario_id")
    private Long usuario_id;

    @JsonProperty(defaultValue = "chamado_id")
    private Long chamado_id;

    @JsonProperty(defaultValue = "usuario_id_finish")
    private Long usuario_id_finish;

    @JsonProperty(defaultValue = "categoria_id")
    private Long categoria_id;

    @JsonProperty(defaultValue = "subCategoria_id")
    private Long subCategoria_id;

    @JsonProperty(defaultValue = "canal_id")
    private Long canal_id;

    public Long getChamado_id() {
        return chamado_id;
    }

    public void setChamado_id(Long chamado_id) {
        this.chamado_id = chamado_id;
    }

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

    public Long getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(Long usuario_id) {
        this.usuario_id = usuario_id;
    }

    public Long getUsuario_id_finish() {
        return usuario_id_finish;
    }

    public void setUsuario_id_finish(Long usuario_id_finish) {
        this.usuario_id_finish = usuario_id_finish;
    }

    public Long getCategoria_id() {
        return categoria_id;
    }

    public void setCategoria_id(Long categoria_id) {
        this.categoria_id = categoria_id;
    }

    public Long getSubCategoria_id() {
        return subCategoria_id;
    }

    public void setSubCategoria_id(Long subCategoria_id) {
        this.subCategoria_id = subCategoria_id;
    }

    public Long getCanal_id() {
        return canal_id;
    }

    public void setCanal_id(Long canal_id) {
        this.canal_id = canal_id;
    }

}
