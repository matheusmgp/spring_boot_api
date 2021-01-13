package com.mgptech.api.myrestapi.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;

@Entity
@Component
@Table(name = "setor")
@JsonIgnoreProperties(ignoreUnknown=true)
public class Setor extends  BaseEntity implements Serializable {

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "status", nullable = false)
    private Boolean status;

    @Column(name = "tempo", nullable = false)
    private String tempo;

    @Column(name = "tempo_rapido", nullable = false)
    private String tempo_rapido;


    @JsonManagedReference
    @OneToMany(mappedBy = "setor")
    private List<Chamado> chamados;

    public List<Chamado> getChamado() {
        return chamados;
    }

    public void setChamado(List<Chamado> chamado) {
        this.chamados = chamado;
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

    public String getTempo() {
        return tempo;
    }

    public void setTempo(String tempo) {
        this.tempo = tempo;
    }

    public String getTempo_rapido() {
        return tempo_rapido;
    }

    public void setTempo_rapido(String tempo_rapido) {
        this.tempo_rapido = tempo_rapido;
    }
}
