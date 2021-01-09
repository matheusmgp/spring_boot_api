package com.mgptech.api.myrestapi.application.dto.output;

import javax.validation.constraints.NotEmpty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "UsuarioDtoOutput")
public class UsuarioDtoOutput {

	public UsuarioDtoOutput() {
		// TODO Auto-generated constructor stub
	}

    @ApiModelProperty(required = true)
    @NotEmpty
    private Long id;
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
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
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