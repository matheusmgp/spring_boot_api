package com.mgptech.api.myrestapi.application.dto.response;

import com.mgptech.api.myrestapi.application.dto.IdentityDto;
import com.mgptech.api.myrestapi.domain.entities.Categoria;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotEmpty;

@ApiModel(value = "SubCategoriaDtoResponse")
public class SubCategoriaDtoResponse extends IdentityDto {

    @ApiModelProperty(required = true)
    @NotEmpty
    private String nome;

    @ApiModelProperty(required = true)
    @NotEmpty
    private Boolean status;

    @ApiModelProperty( required = true)
    @NotEmpty
    private Categoria categoria;

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

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
