package com.mgptech.api.myrestapi.services.controllers;

import java.lang.reflect.Type;
import java.util.List;

import com.mgptech.api.myrestapi.application.dto.response.UsuarioDtoResponse;
import com.mgptech.api.myrestapi.services.controllers.exceptions.ExistingEmailException;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.mgptech.api.myrestapi.application.dto.request.UsuarioDtoRequest;
import com.mgptech.api.myrestapi.application.dto.IO.UsuarioIO;
import com.mgptech.api.myrestapi.application.service.UsuarioService;
import com.mgptech.api.myrestapi.domain.entities.Usuario;
import com.mgptech.api.myrestapi.services.mapper.ObjectMapperUtils;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioService _usuarioService;
	
	@Autowired
	ObjectMapperUtils  objectMapperUtils ;

	@Autowired
	private PasswordEncoder _passwordEncoder;
	
    @Autowired
    UsuarioIO usuarioIO;
	
	@RequestMapping(value = "/{id}",  method = RequestMethod.GET)
	public ResponseEntity<UsuarioDtoResponse> getById(@PathVariable(value = "id") long id){
		  UsuarioDtoResponse usuarioDtoResponse =  objectMapperUtils.mapTo(_usuarioService.findById(id), UsuarioDtoResponse.class);
		return new ResponseEntity<>(usuarioDtoResponse, HttpStatus.OK);
	}	
	
    @RequestMapping( method =  RequestMethod.POST)
    public ResponseEntity<Usuario> add( @Valid  @RequestBody UsuarioDtoRequest usuarioDTORequest){
    	Usuario usuarioModel = usuarioIO.mapTo(usuarioDTORequest);
		UsuarioDtoRequest usuarioDtoRequest = new UsuarioDtoRequest();
		var userEmailExists = _usuarioService.emailExists(usuarioModel.getEmail());
		if(!userEmailExists) {
			var senhaEncoded = _passwordEncoder.encode(usuarioDTORequest.getSenha());
			usuarioModel.setSenha(senhaEncoded);
		}
    	Usuario savedModel = _usuarioService.create(usuarioModel);
		return new ResponseEntity<>(savedModel, HttpStatus.CREATED);
    }
    
   

	@RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<UsuarioDtoResponse>> findAll(){
		Type type = new TypeToken<List<UsuarioDtoResponse>>() {}.getType();

        List<UsuarioDtoResponse> result = objectMapperUtils.toList(_usuarioService.findAll(), type);
		return new ResponseEntity<>(result, HttpStatus.OK);
    }


    @RequestMapping( method =  RequestMethod.PUT)
    public ResponseEntity<Usuario> update(@RequestBody UsuarioDtoRequest usuarioDTORequest) throws Exception{
    	Usuario usuarioModel = usuarioIO.mapTo(usuarioDTORequest);
    	 Long id = usuarioModel.getId();
    	 Usuario savedUsuario = _usuarioService.update(id,usuarioModel);
		return new ResponseEntity<>(savedUsuario, HttpStatus.OK);
    }
    @DeleteMapping(path = "{id}")
    public void delete(@PathVariable("id") Long id){
    	_usuarioService.delete(id);
    	 
    }
	
}
