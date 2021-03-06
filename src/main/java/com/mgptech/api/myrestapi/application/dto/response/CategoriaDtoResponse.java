package com.mgptech.api.myrestapi.application.dto.response;


import com.mgptech.api.myrestapi.application.dto.IdentityDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotEmpty;

@ApiModel(value = "CategoriaDtoResponse")
public class CategoriaDtoResponse extends IdentityDto {

    @ApiModelProperty(required = true)
    @NotEmpty
    private String nome;

    @ApiModelProperty(required = true)
    @NotEmpty
    private Boolean status;

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
