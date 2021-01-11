package com.mgptech.api.myrestapi.services.controllers;

import java.lang.reflect.Type;
import java.util.List;

import com.mgptech.api.myrestapi.application.dto.response.FilialDtoResponse;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mgptech.api.myrestapi.application.dto.FilialDto;
import com.mgptech.api.myrestapi.application.dto.IO.FilialIO;
import com.mgptech.api.myrestapi.application.service.FilialService;
import com.mgptech.api.myrestapi.domain.entities.Filial;
import com.mgptech.api.myrestapi.services.mapper.ObjectMapperUtils;

@RestController
@RequestMapping("/api/filial")
public class FilialController {

	@Autowired
	private FilialService _filialService;
	
	@Autowired
	ObjectMapperUtils  objectMapperUtils ;
	
    @Autowired
    FilialIO filialIO;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<FilialDtoResponse> getById(@PathVariable(value = "id") long id){
		FilialDtoResponse filialDtoResponse = objectMapperUtils.mapTo(_filialService.findById(id), FilialDtoResponse.class);
		return new ResponseEntity<>(filialDtoResponse, HttpStatus.OK);
	}	
	
    @RequestMapping( method =  RequestMethod.POST)
    public ResponseEntity<Filial> add(@RequestBody FilialDto filialDTO){
    	Filial filialModel = filialIO.mapTo(filialDTO);
    	Filial savedFilial = _filialService.create(filialModel);
		return new ResponseEntity<>(savedFilial, HttpStatus.CREATED);
    }
    
   

	@RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<FilialDtoResponse>> findAll(){
		Type type = new TypeToken<List<FilialDtoResponse>>() {}.getType();

        List<FilialDtoResponse> result = objectMapperUtils.toList(_filialService.findAll(), type);
		return new ResponseEntity<>(result, HttpStatus.OK);
    }


    @RequestMapping( method =  RequestMethod.PUT)
    public ResponseEntity<Filial> update(@RequestBody FilialDto filialDTO) throws Exception{
    	 Filial filialModel = filialIO.mapTo(filialDTO);
    	 Long id = filialModel.getId();
    	 Filial savedFilial = _filialService.update(id,filialModel);
		return new ResponseEntity<>(savedFilial, HttpStatus.OK);
    }
    @DeleteMapping(path = "{id}")
    public void delete(@PathVariable("id") Long id){
    	_filialService.delete(id);
    	 
    }
	
}
