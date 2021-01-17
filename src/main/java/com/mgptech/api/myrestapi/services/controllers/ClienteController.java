package com.mgptech.api.myrestapi.services.controllers;

import com.mgptech.api.myrestapi.application.dto.IO.CanaisIO;
import com.mgptech.api.myrestapi.application.dto.IO.ClienteIO;
import com.mgptech.api.myrestapi.application.dto.request.CanaisDtoRequest;
import com.mgptech.api.myrestapi.application.dto.request.ClienteDtoRequest;
import com.mgptech.api.myrestapi.application.dto.response.CanaisDtoResponse;
import com.mgptech.api.myrestapi.application.dto.response.ClienteDtoResponse;
import com.mgptech.api.myrestapi.application.service.CanaisService;
import com.mgptech.api.myrestapi.application.service.ClienteService;
import com.mgptech.api.myrestapi.domain.entities.Canais;
import com.mgptech.api.myrestapi.domain.entities.Cliente;
import com.mgptech.api.myrestapi.services.mapper.ObjectMapperUtils;
import org.modelmapper.TypeToken;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.lang.reflect.Type;
import java.util.List;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController {

    private ClienteService _clienteService;
    ObjectMapperUtils objectMapperUtils ;
    ClienteIO clienteIO;

    public ClienteController(ClienteService _clienteService, ObjectMapperUtils objectMapperUtils, ClienteIO clienteIO) {
        this._clienteService = _clienteService;
        this.objectMapperUtils = objectMapperUtils;
        this.clienteIO = clienteIO;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)

    public ResponseEntity<ClienteDtoResponse> getById(@PathVariable(value = "id") long id){
        ClienteDtoResponse clienteDtoResponse = objectMapperUtils.mapTo(_clienteService.findById(id), ClienteDtoResponse.class);
        return new ResponseEntity<>(clienteDtoResponse, HttpStatus.OK);
    }

    @RequestMapping( method = RequestMethod.GET)
    public ResponseEntity<List<ClienteDtoResponse>> findAll(){
        Type type = new TypeToken<List<ClienteDtoResponse>>() {}.getType();
        List<ClienteDtoResponse> result = objectMapperUtils.toList(_clienteService.findAll(), type);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @RequestMapping( method =  RequestMethod.POST)
    public ResponseEntity<Cliente> add(@Valid @RequestBody ClienteDtoRequest clienteDtoRequest){
        Cliente clienteModel = clienteIO.mapTo(clienteDtoRequest);
        Cliente savedCliente = _clienteService.create(clienteModel);
        return new ResponseEntity<>(savedCliente, HttpStatus.CREATED);
    }

    @RequestMapping( method =  RequestMethod.PUT)
    public ResponseEntity<Cliente> update(@Valid @RequestBody ClienteDtoRequest clienteDtoRequest)  {

        Cliente clienteModel = clienteIO.mapTo(clienteDtoRequest);
        if(clienteModel.getId() <= 0){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        Cliente clienteRetorno = _clienteService.findById(clienteModel.getId());
        if(clienteRetorno != null){
            Long id = clienteModel.getId();
            // canaisModel.setStatus(true);
            Cliente savedCliente = _clienteService.update(id,clienteModel);
            return new ResponseEntity<>(savedCliente, HttpStatus.OK);

        }

        return new ResponseEntity<>(null, HttpStatus.OK);

    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id){
        _clienteService.delete(id);
        return new ResponseEntity<>("ID: "+id+" deletado.", HttpStatus.OK);
    }


}
