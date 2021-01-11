package com.mgptech.api.myrestapi.application.dto.request;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.mgptech.api.myrestapi.application.dto.IdentityDto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

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

}