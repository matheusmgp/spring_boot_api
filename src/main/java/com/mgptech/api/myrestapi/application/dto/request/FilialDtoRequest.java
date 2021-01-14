package com.mgptech.api.myrestapi.application.dto.request;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.mgptech.api.myrestapi.application.dto.IdentityDto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.Date;

/**
 * FilialDto
 */
public class FilialDtoRequest extends IdentityDto {


    @JsonProperty(defaultValue = "fantasia")
    @NotBlank(message = "Nome fantasia é obrigatório.")
    @Min(value = 8, message = "Nome fantasia não pode ser menor que 8.")
    @Max(value = 40, message = "Nome fantasia não pode ser maior que 40.")
    private String fantasia;

    @JsonProperty(defaultValue = "razao")
    @NotBlank(message = "Razão social é obrigatório.")
    @Min(value = 8, message = "Razão social não pode ser menor que 8.")
    @Max(value = 40, message = "Razão social não pode ser maior que 40.")
    private String razao;

    @JsonProperty(defaultValue = "cnpj")
    @NotBlank(message = "CNPJ é obrigatório.")
    @Min(value = 14, message = "CNPJ não pode ser menor que 14.")
    @Max(value = 14, message = "CNPJ não pode ser maior que 14.")
    private String cnpj;

    @JsonProperty(defaultValue = "mac")
    @Max(value = 20, message = "mac não pode ser maior que 14.")
    private String mac;

    @JsonProperty(defaultValue = "diaVencimento")
    @NotBlank(message = "dia do vencimento é obrigatório.")
    private Integer diaVencimento;

    @JsonProperty(defaultValue = "dataBloqueio")
    @NotBlank(message = "data do bloqueio é obrigatório.")
    private java.util.Date dataBloqueio;


    @JsonProperty(defaultValue = "dataExpiracao")
    @NotBlank(message = "data da expiracao é obrigatório.")
    private java.util.Date dataExpiracao;

    @JsonProperty(defaultValue = "logradouro")
    @NotBlank(message = "logradouro é obrigatório.")
    @Max(value = 50, message = "logradouro não pode ser maior que 50.")
    private String logradouro;
    @JsonProperty(defaultValue = "cidade")
    @Max(value = 35, message = "cidadenão pode ser maior que 35.")
    @NotBlank(message = "cidade é obrigatório.")
    private String cidade;
    @JsonProperty(defaultValue = "bairro")
    @Max(value = 35, message = "bairro não pode ser maior que 35.")
    @NotBlank(message = "bairro é obrigatório.")
    private String bairro;
    @JsonProperty(defaultValue = "cep")
    @Max(value = 7, message = "cep não pode ser maior que 7.")
    @NotBlank(message = "cep é obrigatório.")
    private String cep;
    @JsonProperty(defaultValue = "numero")
    @Max(value = 10, message = "numero não pode ser maior que 10.")
    @NotBlank(message = "numero é obrigatório.")
    private String numero;
    @JsonProperty(defaultValue = "complemento")
    private String complemento;
    @JsonProperty(defaultValue = "uf")
    @Max(value = 2, message = "uf não pode ser maior que 2.")
    @NotBlank(message = "uf é obrigatório.")
    private String uf;

    @JsonProperty(defaultValue = "filial_id")

    @NotBlank(message = "filial_id é obrigatório.")
    private Long filial_id;

  /*  public Long getFilial_id() {
        return this.getId();
    }

    public void setFilial_id(Long filial_id) {
        this.filial_id = filial_id;
    }*/

    public String getLogradouro() {
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