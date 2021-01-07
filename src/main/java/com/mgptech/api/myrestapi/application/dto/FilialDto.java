package com.mgptech.api.myrestapi.application.dto;


import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * FilialDto
 */
public class FilialDto extends IdentityDto{

    @JsonProperty(defaultValue = "fantasia")
   // @NotBlank(message = "Nome fantasia é requerido")
    private String fantasia;

    @JsonProperty(defaultValue = "razao")
   // @NotBlank(message = "Razao social é requerido")
    private String razao;

    @JsonProperty(defaultValue = "cnpj")
   // @NotBlank(message = "CNPJ é requerido")
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