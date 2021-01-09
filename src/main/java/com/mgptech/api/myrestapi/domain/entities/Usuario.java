package com.mgptech.api.myrestapi.domain.entities;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

/**
 * Usuario
 */
@Entity
@Component
@Table(name = "usuario")
public class Usuario extends BaseEntity implements Serializable{

	@Column(name = "first_name", nullable = false)
    private String firstName;    

    @Column(name = "last_name", nullable = false)
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