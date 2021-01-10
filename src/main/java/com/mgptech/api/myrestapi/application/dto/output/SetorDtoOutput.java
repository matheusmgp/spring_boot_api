package com.mgptech.api.myrestapi.application.dto.output;

import com.mgptech.api.myrestapi.application.dto.IdentityDto;
import com.mgptech.api.myrestapi.domain.entities.Chamado;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@ApiModel(value = "SetorDtoOutput")
public class SetorDtoOutput extends IdentityDto {


    @ApiModelProperty(required = true)
    @NotEmpty
    private String nome;

    @ApiModelProperty(required = true)
    @NotEmpty
    private Boolean status;

    private List<Chamado> chamados;

    public List<Chamado> getChamados() {
        return chamados;
    }

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
}
