package com.mgptech.api.myrestapi.application.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public abstract class IdentityDto {
	  @JsonProperty(defaultValue = "id")
	    private Long id;

	    /**
	     * @return the id
	     */
	    public Long getId() {
	        return id;
	    }

	    /**
	     * @param id the id to set
	     */
	    public IdentityDto setId(Long id) {
	        this.id = id;
	        return this;
	    }
	}
