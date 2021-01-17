package com.mgptech.api.myrestapi.services.controllers;


import com.mgptech.api.myrestapi.application.dto.request.CanaisDtoRequest;
import com.mgptech.api.myrestapi.application.dto.IO.CanaisIO;
import com.mgptech.api.myrestapi.application.dto.response.CanaisDtoResponse;
import com.mgptech.api.myrestapi.application.service.*;
import com.mgptech.api.myrestapi.domain.entities.Canais;
import com.mgptech.api.myrestapi.services.mapper.ObjectMapperUtils;
import org.modelmapper.TypeToken;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.lang.reflect.Type;
import java.util.List;

@RestController()
@RequestMapping("/api/canal")
@CrossOrigin(origins = "http://localhost:8080")
public class CanaisController {


    private CanaisService _canaisService;
    ObjectMapperUtils objectMapperUtils ;
    CanaisIO canaisIO;

    public CanaisController(CanaisService _canaisService, ObjectMapperUtils objectMapperUtils, CanaisIO canaisIO) {
        this._canaisService = _canaisService;
        this.objectMapperUtils = objectMapperUtils;
        this.canaisIO = canaisIO;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<CanaisDtoResponse> getById(@PathVariable(value = "id") long id){
        CanaisDtoResponse canaisDtoResponse = objectMapperUtils.mapTo(_canaisService.findById(id), CanaisDtoResponse.class);
        return new ResponseEntity<>(canaisDtoResponse, HttpStatus.OK);
    }

    @RequestMapping( method = RequestMethod.GET)
    public ResponseEntity<List<CanaisDtoResponse>> findAll(){
        Type type = new TypeToken<List<CanaisDtoResponse>>() {}.getType();
        List<CanaisDtoResponse> result = objectMapperUtils.toList(_canaisService.findAll(), type);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @RequestMapping( method =  RequestMethod.POST)
    public ResponseEntity<Canais> add(@Valid @RequestBody CanaisDtoRequest canaisDtoRequire){
        Canais canalModel = canaisIO.mapTo(canaisDtoRequire);
        canalModel.setId(0);
        Canais savedCanais = _canaisService.create(canalModel);
        return new ResponseEntity<>(savedCanais, HttpStatus.CREATED);
    }

    @RequestMapping( method =  RequestMethod.PUT)
    public ResponseEntity<Canais> update(@Valid @RequestBody CanaisDtoRequest canaisDtoRequest)  {

        Canais canaisModel = canaisIO.mapTo(canaisDtoRequest);
        if(canaisModel.getId() <= 0){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        Canais canalRetorno = _canaisService.findById(canaisModel.getId());
        if(canalRetorno != null){
            Long id = canaisModel.getId();
            Canais savedCanal = _canaisService.update(id,canaisModel);
            return new ResponseEntity<>(savedCanal, HttpStatus.OK);

        }

        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);

    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id){
        _canaisService.delete(id);
        return new ResponseEntity<>("ID: "+id+" deletado.", HttpStatus.OK);
    }

    @RequestMapping(value = "/teste/{nome}", method = RequestMethod.GET)
    public List<Canais> getByName(@PathVariable(value = "nome") String nome){
        List<Canais> retorno = _canaisService.findByNomeContaining(nome);
       return retorno;
    }
}
