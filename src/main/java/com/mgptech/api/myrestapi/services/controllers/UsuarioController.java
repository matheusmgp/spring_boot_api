package com.mgptech.api.myrestapi.services.controllers;

import java.lang.reflect.Type;
import java.util.List;

import com.mgptech.api.myrestapi.application.dto.response.UsuarioDtoResponse;
import com.mgptech.api.myrestapi.services.controllers.exceptions.EntityNotCreatedException;
import org.modelmapper.TypeToken;
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
	

	private UsuarioService _usuarioService;
	ObjectMapperUtils  objectMapperUtils ;
	private PasswordEncoder _passwordEncoder;
    UsuarioIO usuarioIO;

	public UsuarioController(UsuarioService _usuarioService, ObjectMapperUtils objectMapperUtils, PasswordEncoder _passwordEncoder, UsuarioIO usuarioIO) {
		this._usuarioService = _usuarioService;
		this.objectMapperUtils = objectMapperUtils;
		this._passwordEncoder = _passwordEncoder;
		this.usuarioIO = usuarioIO;
	}

	@RequestMapping(value = "/{id}",  method = RequestMethod.GET)
	public ResponseEntity<UsuarioDtoResponse> getById(@PathVariable(value = "id") long id){
		  UsuarioDtoResponse usuarioDtoResponse =  objectMapperUtils.mapTo(_usuarioService.findById(id), UsuarioDtoResponse.class);
		return new ResponseEntity<>(usuarioDtoResponse, HttpStatus.OK);
	}	
	
    @RequestMapping( method =  RequestMethod.POST)
    public ResponseEntity<Usuario> add( @Valid  @RequestBody UsuarioDtoRequest usuarioDTORequest){
		Usuario savedModel;
    	Usuario usuarioModel = usuarioIO.mapTo(usuarioDTORequest);

		var userEmailExists = _usuarioService.emailExists(usuarioModel.getEmail());
		if(!userEmailExists) {
			var senhaEncoded = _passwordEncoder.encode(usuarioDTORequest.getSenha());
			 usuarioModel.setSenha(senhaEncoded);
			 savedModel = _usuarioService.create(usuarioModel);
			return new ResponseEntity<>(savedModel, HttpStatus.CREATED);
		}
		throw new EntityNotCreatedException("Email já existe");
    }

    @RequestMapping( method =  RequestMethod.PUT)
	public ResponseEntity<Usuario> update(@Valid @RequestBody UsuarioDtoRequest usuarioDTORequest) {
		Usuario usuarioModel = usuarioIO.mapTo(usuarioDTORequest);

		var oldEmail = _usuarioService.findById(usuarioDTORequest.getId()).getEmail();

		var userEmailExists = _usuarioService.emailExists(usuarioModel.getEmail());
 		var newEmail =usuarioModel.getEmail();

 		var igual = newEmail.equals(oldEmail);
		if( userEmailExists && igual || !userEmailExists ){
			Long id = usuarioModel.getId();
			var senhaEncoded = _passwordEncoder.encode(usuarioDTORequest.getSenha());
			usuarioModel.setSenha(senhaEncoded);
			Usuario savedUsuario = _usuarioService.update(id,usuarioModel);
			return new ResponseEntity<>(savedUsuario, HttpStatus.OK);
		}else {
			throw new EntityNotCreatedException("Email já existe");
		}

	}

	@RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<UsuarioDtoResponse>> findAll(){
		Type type = new TypeToken<List<UsuarioDtoResponse>>() {}.getType();

        List<UsuarioDtoResponse> result = objectMapperUtils.toList(_usuarioService.findAll(), type);
		return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @DeleteMapping(path = "{id}")
    public void delete(@PathVariable("id") Long id){
    	_usuarioService.delete(id);
    	 
    }
	
}
