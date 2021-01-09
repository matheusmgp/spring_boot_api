package com.mgptech.api.myrestapi.application.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mgptech.api.myrestapi.domain.entities.Chamado;
import com.mgptech.api.myrestapi.domain.entities.Filial;
import com.mgptech.api.myrestapi.domain.entities.Usuario;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * ChamadoDto
 */

@Data
public class ChamadoDto /*extends IdentityDto*/{

    @JsonProperty(defaultValue = "id")
    private Long id;

    /**
     * @return the id
     */
    public Long getId() {
        return this.id;
    }

    /**
     * @param id the id to set
     */
	
    @JsonProperty(defaultValue = "protocolo")
    private String protocolo;

    @JsonProperty(defaultValue = "dataAbertura")
    private String dataAbertura;

    @JsonProperty(defaultValue = "dataFechamento")
    private String dataFechamento;

    @JsonProperty(defaultValue = "filial")
    private Filial filial;

    @JsonProperty(defaultValue = "usuario")
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