package com.mgptech.api.myrestapi.application.dto.request;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.mgptech.api.myrestapi.application.dto.IdentityDto;
import com.mgptech.api.myrestapi.domain.entities.FilialEndereco;

import javax.persistence.Column;
import javax.validation.constraints.*;
import java.util.Date;

/**
 * FilialDto
 */
public class FilialDtoRequest extends IdentityDto {


    @JsonProperty(defaultValue = "fantasia")
    @NotBlank(message = "Nome fantasia é obrigatório.")
    @Size(min=4, max=35)
    private String fantasia;

    @JsonProperty(defaultValue = "razao")
    @NotBlank(message = "Razão social é obrigatório.")
    @Size(min=4, max=35)
    private String razao;

    @JsonProperty(defaultValue = "status")
    private Boolean status;

    @JsonProperty(defaultValue = "cnpj")
    @NotBlank(message = "CNPJ é obrigatório.")
    @Size(min=14, max=14)
    private String cnpj;

    @JsonProperty(defaultValue = "mac")
    @Size(min=4, max=35)
    private String mac;

    @JsonProperty(defaultValue = "diaVencimento")
    @NotNull
    private Integer diaVencimento;

    @JsonProperty(defaultValue = "dataBloqueio")
    @NotNull
    private Date dataBloqueio;


    @JsonProperty(defaultValue = "dataExpiracao")
    @NotNull
    private Date dataExpiracao;

   /* @JsonProperty(defaultValue = "logradouro")
    @NotBlank(message = "logradouro é obrigatório.")
    @Size(min=4, max=50)
    private String logradouro;
    @JsonProperty(defaultValue = "cidade")
    @Size(min=4, max=50)
    @NotBlank(message = "cidade é obrigatório.")
    private String cidade;
    @JsonProperty(defaultValue = "bairro")
    @Size(min=4, max=35)
    @NotBlank(message = "bairro é obrigatório.")
    private String bairro;
    @JsonProperty(defaultValue = "cep")
    @Size(max=8)
    @NotBlank(message = "cep é obrigatório.")
    private String cep;
    @JsonProperty(defaultValue = "numero")
    @Size(max=35)
    @NotBlank(message = "numero é obrigatório.")
    private String numero;
    @JsonProperty(defaultValue = "complemento")
    private String complemento;
    @JsonProperty(defaultValue = "uf")
    @Size(min=2, max=2)
    @NotBlank(message = "uf é obrigatório.")
    private String uf;

    @JsonProperty(defaultValue = "filial_id")
    private Long filial_id;*/

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @JsonProperty(defaultValue = "endereco_id")
    private FilialEnderecoDtoRequest filialEndereco;

    public FilialEnderecoDtoRequest getFilialEndereco() {
        return filialEndereco;
    }

    public void setFilialEndereco(FilialEnderecoDtoRequest filialEndereco) {
        this.filialEndereco = filialEndereco;
    }

    /*public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }
*/
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

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public Integer getDiaVencimento() {
        return diaVencimento;
    }

    public void setDiaVencimento(Integer diaVencimento) {
        this.diaVencimento = diaVencimento;
    }

    public Date getDataBloqueio() {
        return dataBloqueio;
    }

    public void setDataBloqueio(Date dataBloqueio) {
        this.dataBloqueio = dataBloqueio;
    }

    public Date getDataExpiracao() {
        return dataExpiracao;
    }

    public void setDataExpiracao(Date dataExpiracao) {
        this.dataExpiracao = dataExpiracao;
    }
}