package com.mgptech.api.myrestapi.services.controllers;

import java.util.List;

import org.modelmapper.TypeToken;
import java.lang.reflect.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mgptech.api.myrestapi.application.dto.ChamadoDto;
import com.mgptech.api.myrestapi.application.dto.IO.ChamadoIO;
import com.mgptech.api.myrestapi.application.dto.output.ChamadoDtoOutput;
import com.mgptech.api.myrestapi.application.service.ChamadoService;
import com.mgptech.api.myrestapi.domain.entities.Chamado;
import com.mgptech.api.myrestapi.services.mapper.ObjectMapperUtils;

@RestController
@RequestMapping("/api/chamado")
public class ChamadoController {

	@Autowired
	private ChamadoService _chamadoService;
	
	@Autowired
	ObjectMapperUtils  objectMapperUtils ;
	
    @Autowired
    ChamadoIO chamadoIO;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ChamadoDtoOutput getById(@PathVariable(value = "id") long id){
		  return objectMapperUtils.mapTo(_chamadoService.findById(id), ChamadoDtoOutput.class);
	}	
	
    @RequestMapping( method =  RequestMethod.POST)
    public Chamado add(@RequestBody ChamadoDto chamadoDto){
       Chamado chamadoModel = chamadoIO.mapTo(chamadoDto);
       Chamado savedChamado = _chamadoService.create(chamadoModel);        
        return savedChamado;
    }
    
   

	@RequestMapping( method = RequestMethod.GET)
    public List<ChamadoDtoOutput> findAll(){
		Type type = new TypeToken<List<ChamadoDtoOutput>>() {}.getType();

        List<ChamadoDtoOutput> result = objectMapperUtils.toList(_chamadoService.findAll(), type);
    	 return result;	
    }


    @RequestMapping( method =  RequestMethod.PUT)
    public Chamado update(@RequestBody ChamadoDto chamadoDto) throws Exception{
    	 Chamado chamadoModel = chamadoIO.mapTo(chamadoDto);
    	 Long id = chamadoModel.getId();
         Chamado savedChamado = _chamadoService.update(id,chamadoModel);        
         return savedChamado;
    }
    @DeleteMapping(path = "{id}")
    public void delete(@PathVariable("id") Long id){
    	  _chamadoService.delete(id);
    	 
    }
	
}
