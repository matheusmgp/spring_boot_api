package com.mgptech.api.myrestapi.application.dto.output;


import com.mgptech.api.myrestapi.application.dto.IdentityDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotEmpty;

@ApiModel(value = "CategoriaDtoOutput")
public class CategoriaDtoOutput extends IdentityDto {

    @ApiModelProperty(required = true)
    @NotEmpty
    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
