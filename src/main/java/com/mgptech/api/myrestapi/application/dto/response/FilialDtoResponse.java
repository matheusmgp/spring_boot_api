package com.mgptech.api.myrestapi.application.dto.response;

import javax.validation.constraints.NotEmpty;

import com.mgptech.api.myrestapi.application.dto.IdentityDto;
import com.mgptech.api.myrestapi.domain.entities.Chamado;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import java.util.List;

@ApiModel(value = "FilialDtoResponse")
public class FilialDtoResponse extends IdentityDto {

	public FilialDtoResponse() {
		// TODO Auto-generated constructor stub
	}
	@ApiModelProperty(required = true)
    @NotEmpty
    private String fantasia;

	@ApiModelProperty(required = true)
    @NotEmpty
    private String razao;

	@ApiModelProperty(required = true)
    @NotEmpty
    private String cnpj;

    @ApiModelProperty(required = true)
    @NotEmpty
    private String mac;
    @ApiModelProperty(required = true)
    @NotEmpty
    private Integer diaVencimento;
    @ApiModelProperty(required = true)
    @NotEmpty
    private  java.util.Date dataBloqueio;
    @ApiModelProperty(required = true)
    @NotEmpty
    private  java.util.Date dataExpiracao;

    private List<Chamado> chamados;

    public List<Chamado> getChamados() {
        return chamados;
    }

    public void setChamados(List<Chamado> chamados) {
        this.chamados = chamados;
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
}