/**
 * 
 */
package com.mgptech.api.myrestapi.application.dto.output;

import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mgptech.api.myrestapi.application.dto.IdentityDto;
import com.mgptech.api.myrestapi.domain.entities.Filial;
import com.mgptech.api.myrestapi.domain.entities.Usuario;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author matheus
 *
 */
@ApiModel(value = "ChamadoDtoOutput")
public class ChamadoDtoOutput extends IdentityDto {


	public ChamadoDtoOutput() {
		// TODO Auto-generated constructor stub
	}

		@ApiModelProperty(required = true)
		@NotEmpty
	    private String protocolo;

		@ApiModelProperty(required = true)
		@NotEmpty
	    private String dataAbertura;

	    private String dataFechamento;

	    @ApiModelProperty( required = true)
	    @NotEmpty
	    private Filial filial;

	    @ApiModelProperty( required = true)
	    @NotEmpty
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
