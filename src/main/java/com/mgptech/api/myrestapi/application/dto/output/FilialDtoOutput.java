package com.mgptech.api.myrestapi.application.dto.output;

import javax.validation.constraints.NotEmpty;

import com.mgptech.api.myrestapi.application.dto.IdentityDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "FilialDtoOutput")
public class FilialDtoOutput extends IdentityDto {

	public FilialDtoOutput() {
		// TODO Auto-generated constructor stub
	}


	@ApiModelProperty(required = true)
    @NotEmpty
    private String fantasia;

	@ApiModelProperty(required = true)
    @NotEmpty
    private String razao;

	@ApiModelProperty(required = true)
    @NotEmpty
    private String cnpj;

     public String getFantasia() {
        return this.fantasia;
     }
     public void setFantasia(String fantasia) {
        this.fantasia = fantasia;
     }



    public String getRazao() {
    	return this.razao;
    }
    public void setRazao(String razao) {
    	this.razao = razao;
    }


    public String getCnpj() {
    	return this.cnpj;
    }
    public void setCnpj(String cnpj) {
    	this.cnpj = cnpj;
    }

}