package com.mgptech.api.myrestapi.domain.entities;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
@MappedSuperclass
public abstract class BaseEntity {
	
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "id", unique = true, nullable = false)
	    public long id;

	  
	    public long getId() {
	        return this.id;
	    }

	    public BaseEntity setId(long id) {
	        this.id = id;
	        return this;
	    }
	    
	}
