package com.mgptech.api.myrestapi.application.dto.response;

import javax.validation.constraints.NotEmpty;

import com.mgptech.api.myrestapi.application.dto.IdentityDto;
import com.mgptech.api.myrestapi.domain.entities.Chamado;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel(value = "UsuarioDtoResponse")
public class UsuarioDtoResponse extends IdentityDto {

	public UsuarioDtoResponse() {
		// TODO Auto-generated constructor stub
	}


	@ApiModelProperty(required = true)
    @NotEmpty
    private String firstName;
    
	@ApiModelProperty(required = true)
    @NotEmpty
    private String lastName;
   
    private Boolean acesso;


    private List<Chamado> chamados;

    public List<Chamado> getChamados() {
        return chamados;
    }

    public String getFirstName() {
    	return this.firstName;
    }
    public void setFirstName(String firstName) {
    	this.firstName = firstName;
    }


    public String getLastName() {
    	return this.lastName;
    }
    public void setLastName(String lastName) {
    	this.lastName = lastName;
    }


    public Boolean getAcesso() {
    	return this.acesso;
    }
    public void setAcesso(Boolean acesso) {
    	this.acesso = acesso;
    }

}