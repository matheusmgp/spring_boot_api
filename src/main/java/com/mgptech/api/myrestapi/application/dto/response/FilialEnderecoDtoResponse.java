package com.mgptech.api.myrestapi.application.dto.response;

import com.mgptech.api.myrestapi.application.dto.IdentityDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotEmpty;

@ApiModel(value = "FilialEnderecoDtoResponse")
public class FilialEnderecoDtoResponse extends IdentityDto {

    @ApiModelProperty(required = true)
    @NotEmpty
    private String logradouto;
    @ApiModelProperty(required = true)
    @NotEmpty
    private String cidade;
    @ApiModelProperty(required = true)
    @NotEmpty
    private String bairro;
    @ApiModelProperty(required = true)
    @NotEmpty
    private String cep;
    @ApiModelProperty(required = true)
    @NotEmpty
    private String numero;
    @ApiModelProperty(required = true)
    private String complemento;
    @ApiModelProperty(required = true)
    @NotEmpty
    private String uf;

    public String getLogradouto() {
        return logradouto;
    }

    public void setLogradouto(String logradouto) {
        this.logradouto = logradouto;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }
}
