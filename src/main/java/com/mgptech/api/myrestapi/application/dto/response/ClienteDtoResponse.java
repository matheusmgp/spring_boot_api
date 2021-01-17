package com.mgptech.api.myrestapi.application.dto.response;

import com.mgptech.api.myrestapi.application.dto.IdentityDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "ClienteDtoResponse")
public class ClienteDtoResponse extends IdentityDto {


    @ApiModelProperty(required = true)
    private String nome;
    @ApiModelProperty(required = true)
    private String cpf;
    @ApiModelProperty(required = true)
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
