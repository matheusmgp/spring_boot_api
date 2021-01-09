package com.mgptech.api.myrestapi.application.dto.output;

import javax.validation.constraints.NotEmpty;

import com.mgptech.api.myrestapi.application.dto.IdentityDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "UsuarioDtoOutput")
public class UsuarioDtoOutput extends IdentityDto {

	public UsuarioDtoOutput() {
		// TODO Auto-generated constructor stub
	}


	@ApiModelProperty(required = true)
    @NotEmpty
    private String firstName;
    
	@ApiModelProperty(required = true)
    @NotEmpty
    private String lastName;
   
    private Boolean acesso;

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