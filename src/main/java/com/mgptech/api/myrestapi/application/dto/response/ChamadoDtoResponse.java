/**
 * 
 */
package com.mgptech.api.myrestapi.application.dto.response;

import javax.validation.constraints.NotEmpty;

import com.mgptech.api.myrestapi.application.dto.IdentityDto;
import com.mgptech.api.myrestapi.domain.entities.Filial;
import com.mgptech.api.myrestapi.domain.entities.Setor;
import com.mgptech.api.myrestapi.domain.entities.Usuario;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author matheus
 *
 */
@ApiModel(value = "ChamadoDtoResponse")
public class ChamadoDtoResponse extends IdentityDto {


	public ChamadoDtoResponse() {
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

		@ApiModelProperty( required = false)
		@NotEmpty
		private Usuario usuario_id_finish;

		@ApiModelProperty( required = false)
		@NotEmpty
		private Usuario usuario_id_redirect;

		@ApiModelProperty( required = true)
		@NotEmpty
		private Setor setor;

		@ApiModelProperty( required = true)
		@NotEmpty
		private Boolean status;

		public Usuario getUsuario_finish() {
			return usuario_id_finish;
		}

		public void setUsuario_finish(Usuario usuario_finish) {
			this.usuario_id_finish = usuario_finish;
		}

		public Usuario getUsuario_redirect() {
			return usuario_id_redirect;
		}

		public void setUsuario_redirect(Usuario usuario_redirect) {
			this.usuario_id_redirect = usuario_redirect;
		}

		public Boolean getStatus() {
			return status;
		}

		public void setStatus(Boolean status) {
			this.status = status;
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
