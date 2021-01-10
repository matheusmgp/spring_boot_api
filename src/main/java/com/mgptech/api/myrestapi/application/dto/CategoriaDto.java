package com.mgptech.api.myrestapi.application.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
/**
 * CategoriaDto
 */
public class CategoriaDto extends IdentityDto {


    @JsonProperty(defaultValue = "nome")
    private String nome;


    
    public String getNome() {
    	return this.nome;
    }
    public void setNome(String nome) {
    	this.nome = nome;
    }  

}