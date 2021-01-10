package com.mgptech.api.myrestapi.services.controllers;

import java.util.List;

import org.modelmapper.TypeToken;
import java.lang.reflect.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<ChamadoDtoOutput> getById(@PathVariable(value = "id") long id){
        ChamadoDtoOutput chamadoDtoOutput = objectMapperUtils.mapTo(_chamadoService.findById(id), ChamadoDtoOutput.class);
       // return ResponseEntity.ok(chamadoDtoOutput);
        return new ResponseEntity<>(chamadoDtoOutput, HttpStatus.OK);
	}	
	
    @RequestMapping( method =  RequestMethod.POST)
    public ResponseEntity<Chamado> add(@RequestBody ChamadoDto chamadoDto){
       Chamado chamadoModel = chamadoIO.mapTo(chamadoDto);
       Chamado savedChamado = _chamadoService.create(chamadoModel);
        return new ResponseEntity<Chamado>(savedChamado, HttpStatus.CREATED);
    }
    
   

	@RequestMapping( method = RequestMethod.GET)
    public ResponseEntity<List<ChamadoDtoOutput>> findAll(){
		Type type = new TypeToken<List<ChamadoDtoOutput>>() {}.getType();

        List<ChamadoDtoOutput> result = objectMapperUtils.toList(_chamadoService.findAll(), type);
        return new ResponseEntity<List<ChamadoDtoOutput>>(result, HttpStatus.OK);
    }


    @RequestMapping( method =  RequestMethod.PUT)
    public ResponseEntity<Chamado> update(@RequestBody ChamadoDto chamadoDto) throws Exception{
    	 Chamado chamadoModel = chamadoIO.mapTo(chamadoDto);
    	 Long id = chamadoModel.getId();
         Chamado savedChamado = _chamadoService.update(id,chamadoModel);
        return new ResponseEntity<Chamado>(savedChamado, HttpStatus.OK);
    }
    @DeleteMapping(path = "{id}")
    public void delete(@PathVariable("id") Long id){
    	  _chamadoService.delete(id);
    }
	
}
