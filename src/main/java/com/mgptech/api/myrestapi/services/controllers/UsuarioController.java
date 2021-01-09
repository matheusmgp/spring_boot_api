package com.mgptech.api.myrestapi.services.controllers;

import java.lang.reflect.Type;
import java.util.List;

import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mgptech.api.myrestapi.application.dto.FilialDto;
import com.mgptech.api.myrestapi.application.dto.UsuarioDto;
import com.mgptech.api.myrestapi.application.dto.IO.FilialIO;
import com.mgptech.api.myrestapi.application.dto.IO.UsuarioIO;
import com.mgptech.api.myrestapi.application.dto.output.FilialDtoOutput;
import com.mgptech.api.myrestapi.application.dto.output.UsuarioDtoOutput;
import com.mgptech.api.myrestapi.application.service.FilialService;
import com.mgptech.api.myrestapi.application.service.UsuarioService;
import com.mgptech.api.myrestapi.domain.entities.Filial;
import com.mgptech.api.myrestapi.domain.entities.Usuario;
import com.mgptech.api.myrestapi.services.mapper.ObjectMapperUtils;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioService _usuarioService;
	
	@Autowired
	ObjectMapperUtils  objectMapperUtils ;
	
    @Autowired
    UsuarioIO usuarioIO;
	
	@RequestMapping(value = "/{id}",  method = RequestMethod.GET)
	public UsuarioDtoOutput getById(@PathVariable(value = "id") long id){
		  return objectMapperUtils.mapTo(_usuarioService.findById(id), UsuarioDtoOutput.class);
	}	
	
    @RequestMapping( method =  RequestMethod.POST)
    public Usuario add(@RequestBody UsuarioDto usuarioDTO){
    	Usuario usuarioModel = usuarioIO.mapTo(usuarioDTO);
    	Usuario savedModel = _usuarioService.create(usuarioModel);        
        return savedModel;
    }
    
   

	@RequestMapping(method = RequestMethod.GET)
    public List<UsuarioDtoOutput> findAll(){
		Type type = new TypeToken<List<UsuarioDtoOutput>>() {}.getType();

        List<UsuarioDtoOutput> result = objectMapperUtils.toList(_usuarioService.findAll(), type);
    	 return result;	
    }


    @RequestMapping( method =  RequestMethod.PUT)
    public Usuario update(@RequestBody UsuarioDto usuarioDTO) throws Exception{
    	Usuario usuarioModel = usuarioIO.mapTo(usuarioDTO);
    	 Long id = usuarioModel.getId();
    	 Usuario savedUsuario = _usuarioService.update(id,usuarioModel);        
         return savedUsuario;
    }
    @DeleteMapping(path = "{id}")
    public void delete(@PathVariable("id") Long id){
    	_usuarioService.delete(id);
    	 
    }
	
}
