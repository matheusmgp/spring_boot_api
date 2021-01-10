package com.mgptech.api.myrestapi.application.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mgptech.api.myrestapi.domain.entities.Chamado;
import com.mgptech.api.myrestapi.domain.entities.Filial;
import com.mgptech.api.myrestapi.domain.entities.Setor;
import com.mgptech.api.myrestapi.domain.entities.Usuario;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * ChamadoDto
 */

@Data
public class ChamadoDto extends IdentityDto {


	
    @JsonProperty(defaultValue = "protocolo")
    private String protocolo;

    @JsonProperty(defaultValue = "dataAbertura")
    private String dataAbertura;

    @JsonProperty(defaultValue = "dataFechamento")
    private String dataFechamento;

    @JsonProperty(defaultValue = "filial")
    private Long filial;

    @JsonProperty(defaultValue = "usuario")
    private Long usuario;

    @JsonProperty(defaultValue = "usuario_id_finish")
    private Long usuario_id_finish;

    @JsonProperty(defaultValue = "usuario_id_redirect")
    private Long usuario_id_redirect;

    @JsonProperty(defaultValue = "status")
    private Boolean status;

    @JsonProperty(defaultValue = "setor")
    private Long setor;

    public Long getFilial() {
        return filial;
    }


    public Long getUsuario_id_finish() {
        return usuario_id_finish;
    }

    public void setUsuario_id_finish(Long usuario_id_finish) {
        this.usuario_id_finish = usuario_id_finish;
    }

    public Long getUsuario_id_redirect() {
        return usuario_id_redirect;
    }

    public void setUsuario_id_redirect(Long usuario_id_redirect) {
        this.usuario_id_redirect = usuario_id_redirect;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public void setFilial(Long filial) {
        this.filial = filial;
    }

    public Long getUsuario() {
        return usuario;
    }

    public void setUsuario(Long usuario) {
        this.usuario = usuario;
    }

    public Long getSetor() {
        return setor;
    }

    public void setSetor(Long setor) {
        this.setor = setor;
    }

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



}