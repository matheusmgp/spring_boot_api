package com.mgptech.api.myrestapi.services.controllers;

import java.lang.reflect.Type;
import java.util.List;

import com.mgptech.api.myrestapi.application.dto.IO.FilialEnderecoIO;
import com.mgptech.api.myrestapi.application.dto.request.FilialEnderecoDtoRequest;
import com.mgptech.api.myrestapi.application.dto.response.FilialDtoResponse;
import com.mgptech.api.myrestapi.application.service.FilialEnderecoService;
import com.mgptech.api.myrestapi.domain.entities.FilialEndereco;
import com.mgptech.api.myrestapi.domain.entities.Usuario;
import com.mgptech.api.myrestapi.services.controllers.exceptions.EntityNotCreatedException;
import com.mgptech.api.myrestapi.services.controllers.exceptions.ExistingEmailException;
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

import com.mgptech.api.myrestapi.application.dto.request.FilialDtoRequest;
import com.mgptech.api.myrestapi.application.dto.IO.FilialIO;
import com.mgptech.api.myrestapi.application.service.FilialService;
import com.mgptech.api.myrestapi.domain.entities.Filial;
import com.mgptech.api.myrestapi.services.mapper.ObjectMapperUtils;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/filial")
public class FilialController {


	private FilialService _filialService;
	private FilialEnderecoService _filialEnderecoService;
	ObjectMapperUtils  objectMapperUtils ;
    FilialIO filialIO;
	FilialEnderecoIO filialEnderecoIO;

	public FilialController(FilialService _filialService, FilialEnderecoService _filialEnderecoService, ObjectMapperUtils objectMapperUtils, FilialIO filialIO, FilialEnderecoIO filialEnderecoIO) {
		this._filialService = _filialService;
		this._filialEnderecoService = _filialEnderecoService;
		this.objectMapperUtils = objectMapperUtils;
		this.filialIO = filialIO;
		this.filialEnderecoIO = filialEnderecoIO;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<FilialDtoResponse> getById(@PathVariable(value = "id") long id){
		FilialDtoResponse filialDtoResponse = objectMapperUtils.mapTo(_filialService.findById(id), FilialDtoResponse.class);
		return new ResponseEntity<>(filialDtoResponse, HttpStatus.OK);
	}	
	
    @RequestMapping( method =  RequestMethod.POST)
    public ResponseEntity<Filial> add(@Valid  @RequestBody FilialDtoRequest filialDtoRequest){
		Boolean cnpjExists = _filialService.cnpjExists(filialDtoRequest.getCnpj());
		if(!cnpjExists){
			FilialEndereco filialEnderecoModel = filialEnderecoIO.mapTo(filialDtoRequest.getFilialEndereco());
			filialEnderecoModel.setId(0L);
			FilialEndereco savedFilialEndereco =_filialEnderecoService.create(filialEnderecoModel);
			Filial filialModel = filialIO.mapTo(filialDtoRequest);
			filialModel.setStatus(true);
			filialModel.setId(0L);
			filialModel.setFilialEndereco(savedFilialEndereco);
			Filial savedFilial = _filialService.create(filialModel);
			return new ResponseEntity<>(savedFilial, HttpStatus.CREATED);
		}

		throw new EntityNotCreatedException("CNPJ já existe");


    }

	@RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<FilialDtoResponse>> findAll(){
		Type type = new TypeToken<List<FilialDtoResponse>>() {}.getType();

        List<FilialDtoResponse> result = objectMapperUtils.toList(_filialService.findAll(), type);
		return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @RequestMapping( method =  RequestMethod.PUT)
    public ResponseEntity<Filial> update(@Valid @RequestBody FilialDtoRequest filialDTORequest) throws Exception{
		if(filialDTORequest.getId() > 0 || filialDTORequest.getId() != null){
			Filial filialModel = filialIO.mapTo(filialDTORequest);
			var filialEnderecoId = _filialEnderecoService.findById(filialDTORequest.getFilialEndereco().getId()).getId();
			FilialEndereco filialEnderecoModel = filialEnderecoIO.mapTo(filialDTORequest.getFilialEndereco());

			FilialEndereco filialEnderecoSaved = _filialEnderecoService.update(filialEnderecoId,filialEnderecoModel);


			var oldCnpj = _filialService.findById(filialDTORequest.getId()).getCnpj();
			var userCnpjExists = _filialService.cnpjExists(filialModel.getCnpj());
			var newCnpj = filialModel.getCnpj();

			var igual = newCnpj.equals(oldCnpj);

			if(userCnpjExists && igual || !userCnpjExists){
				Long id = filialModel.getId();
				filialModel.setFilialEndereco(filialEnderecoSaved);
				Filial savedFilial = _filialService.update(id,filialModel);
				return new ResponseEntity<>(savedFilial, HttpStatus.OK);
			}else {
				throw new EntityNotCreatedException("CNPJ já existe");
			}

		}else {
			throw new EntityNotCreatedException("ID NÃO INFORMADO");
		}
    }

    @DeleteMapping(path = "{id}")
    public void delete(@PathVariable("id") Long id){
    	_filialService.delete(id);
    	 
    }

    private FilialEndereco criaFilialEndereco(FilialEnderecoDtoRequest filialEnderecoDtoRequest){
		FilialEndereco filialEnderecoModel = new FilialEndereco();
		filialEnderecoModel.setLogradouto(filialEnderecoDtoRequest.getLogradouto());
		filialEnderecoModel.setNumero(filialEnderecoDtoRequest.getNumero());
		filialEnderecoModel.setCidade(filialEnderecoDtoRequest.getCidade());
		filialEnderecoModel.setBairro(filialEnderecoDtoRequest.getBairro());
		filialEnderecoModel.setUf(filialEnderecoDtoRequest.getUf());
		filialEnderecoModel.setCep(filialEnderecoDtoRequest.getCep());
		filialEnderecoModel.setId(0L);

		if(filialEnderecoDtoRequest.getComplemento() != null){
			filialEnderecoModel.setComplemento(filialEnderecoDtoRequest.getComplemento());
		}

		return filialEnderecoModel;
	}
}
