package com.mgptech.api.myrestapi.application.dto.request;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.mgptech.api.myrestapi.application.dto.IdentityDto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.Date;

/**
 * FilialDto
 */
public class FilialDtoRequest extends IdentityDto {


    @JsonProperty(defaultValue = "fantasia")
    @NotBlank(message = "Nome fantasia é obrigatório.")
    @Min(value = 8, message = "Nome fantasia não pode ser menor que 8.")
    @Max(value = 40, message = "Nome fantasia não pode ser maior que 40.")
    private String fantasia;

    @JsonProperty(defaultValue = "razao")
    @NotBlank(message = "Razão social é obrigatório.")
    @Min(value = 8, message = "Razão social não pode ser menor que 8.")
    @Max(value = 40, message = "Razão social não pode ser maior que 40.")
    private String razao;

    @JsonProperty(defaultValue = "cnpj")
    @NotBlank(message = "CNPJ é obrigatório.")
    @Min(value = 14, message = "CNPJ não pode ser menor que 14.")
    @Max(value = 14, message = "CNPJ não pode ser maior que 14.")
    private String cnpj;

    @JsonProperty(defaultValue = "mac")
    @Max(value = 20, message = "mac não pode ser maior que 14.")
    private String mac;

    @JsonProperty(defaultValue = "dia_vencimento")
    @NotBlank(message = "dia do vencimento é obrigatório.")
    private Integer diaVencimento;

    @JsonProperty(defaultValue = "data_bloqueio")
    @NotBlank(message = "data do bloqueio é obrigatório.")
    private java.util.Date dataBloqueio;


    @JsonProperty(defaultValue = "dataExpiracao")
    @NotBlank(message = "data da expiracao é obrigatório.")
    @Max(value = 2, message = "dia do vencimento não pode ser maior que 2.")
    private String dataExpiracao;


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

    public String getDataExpiracao() {
        return dataExpiracao;
    }

    public void setDataExpiracao(String dataExpiracao) {
        this.dataExpiracao = dataExpiracao;
    }
}