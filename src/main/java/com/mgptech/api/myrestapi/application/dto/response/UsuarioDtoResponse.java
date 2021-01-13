package com.mgptech.api.myrestapi.application.dto.response;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonProperty;
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
    private String nome;
    @ApiModelProperty(required = true)
    @NotEmpty
    private String email;
    @ApiModelProperty(required = true)
    @NotEmpty
    private String senha;

    private String token;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

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
}