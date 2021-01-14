package com.mgptech.api.myrestapi.domain.entities;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.stereotype.Component;

/**
 * Usuario
 */
@Entity
@Component
@Table(name = "usuario")
@JsonIgnoreProperties(ignoreUnknown=true)
public class Usuario extends BaseEntity implements Serializable{


	@Column(name = "nome", nullable = false)
    private String nome;
    @Column(name = "email", nullable = false,unique=true)
    private String email;
    @Column(name = "senha", nullable = false)
    private String senha;
    @Column(name = "token", nullable = true)
    private String token;
    @Basic
    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Date createdAt;
    @Basic
    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Date updatedAt;
    @JsonManagedReference
    @OneToMany(mappedBy = "usuario")
    private List<Chamado> chamados;
    @JsonManagedReference
    @OneToMany(mappedBy = "usuario")
    private List<Pendencia> pendencias;
    @ManyToOne()
    @JsonIgnore
    @JsonIgnoreProperties(ignoreUnknown=true)
    @JoinColumn(name = "role_id")
    private Role role;


    public Usuario(Long id, String nome, String email, String senha,String token){
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.token = token;
    }
    public Usuario(Long id, String nome, String email, String senha){
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public Usuario(String nome, String email, String senha){
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public Usuario(){

    }

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
    public List<Pendencia> getPendencias() {
        return pendencias;
    }
    public List<Chamado> getChamados() {
        return chamados;
    }
    public void setChamados(List<Chamado> chamados) {
        this.chamados = chamados;
    }
    public void setPendencias(List<Pendencia> pendencias) {
        this.pendencias = pendencias;
    }
    public List<Chamado> getChamado() {
        return chamados;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public Date getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
    public Date getUpdatedAt() {
        return updatedAt;
    }
    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
    public Role getRole() {
        return role;
    }
    public void setRole(Role role) {
        this.role = role;
    }
}