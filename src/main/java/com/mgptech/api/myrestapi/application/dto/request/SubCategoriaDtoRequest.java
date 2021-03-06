package com.mgptech.api.myrestapi.application.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mgptech.api.myrestapi.application.dto.IdentityDto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class SubCategoriaDtoRequest extends IdentityDto {


    @JsonProperty(defaultValue = "nome")
    @NotBlank(message = "Nome é obrigatório.")
    @Min(value = 8, message = "Nome não pode ser menor que 8.")
    @Max(value = 40, message = "Nome não pode ser maior que 40.")
    private String nome;

    @JsonProperty(defaultValue = "status")
    @NotNull
    private Boolean status;

    @JsonProperty(defaultValue = "categoria_id")
    private Long categoria_id;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Long getCategoria_id() {
        return categoria_id;
    }

    public void setCategoria_id(Long categoria_id) {
        this.categoria_id = categoria_id;
    }
}
