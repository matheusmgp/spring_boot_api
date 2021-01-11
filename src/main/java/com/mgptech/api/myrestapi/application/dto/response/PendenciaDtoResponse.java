package com.mgptech.api.myrestapi.application.dto.response;


import com.mgptech.api.myrestapi.domain.entities.Canais;
import com.mgptech.api.myrestapi.domain.entities.Categoria;
import com.mgptech.api.myrestapi.domain.entities.SubCategoria;
import com.mgptech.api.myrestapi.domain.entities.Usuario;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotEmpty;

@ApiModel(value = "PendenciaDtoResponse")
public class PendenciaDtoResponse {

    @ApiModelProperty(required = true)
    @NotEmpty
    private String descricao;

    @ApiModelProperty(required = true)
    @NotEmpty
    private String solucao;

    @ApiModelProperty(required = true)
    @NotEmpty
    private Boolean status;

    @ApiModelProperty(required = true)
    @NotEmpty
    private String dataAbertura;

    @ApiModelProperty(required = true)
    @NotEmpty
    private String dataFechamento;

    @ApiModelProperty(required = true)
    @NotEmpty
    private Usuario usuario;

    @ApiModelProperty(required = true)
    @NotEmpty
    private Usuario usuario_id_finish;

    @ApiModelProperty(required = true)
    @NotEmpty
    private Categoria categoria;

    @ApiModelProperty(required = true)
    @NotEmpty
    private SubCategoria subCategoria;

    @ApiModelProperty(required = true)
    @NotEmpty
    private Canais canal;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getSolucao() {
        return solucao;
    }

    public void setSolucao(String solucao) {
        this.solucao = solucao;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(String dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public String getDataFechamento() {
        return dataFechamento;
    }

    public void setDataFechamento(String dataFechamento) {
        this.dataFechamento = dataFechamento;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getUsuario_id_finish() {
        return usuario_id_finish;
    }

    public void setUsuario_id_finish(Usuario usuario_id_finish) {
        this.usuario_id_finish = usuario_id_finish;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public SubCategoria getSubCategoria() {
        return subCategoria;
    }

    public void setSubCategoria(SubCategoria subCategoria) {
        this.subCategoria = subCategoria;
    }

    public Canais getCanal() {
        return canal;
    }

    public void setCanal(Canais canal) {
        this.canal = canal;
    }
}
