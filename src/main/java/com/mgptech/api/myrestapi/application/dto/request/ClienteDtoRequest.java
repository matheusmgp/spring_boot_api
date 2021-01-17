package com.mgptech.api.myrestapi.application.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mgptech.api.myrestapi.application.dto.IdentityDto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ClienteDtoRequest extends IdentityDto {

    @JsonProperty(defaultValue = "nome")
    @NotBlank(message = "Nome é obrigatório.")
    @Size(min=2, max=35)
    @NotNull
    private String nome;

    @JsonProperty(defaultValue = "cpf")
    @NotBlank(message = "cpf é obrigatório.")
    @Size(min=11, max=11)
    @NotNull
    private String cpf;

    @JsonProperty(defaultValue = "status")
    @NotNull
    private Boolean status;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
