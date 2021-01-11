package com.mgptech.api.myrestapi.services.controllers;


import com.mgptech.api.myrestapi.application.dto.request.CanaisDtoRequest;
import com.mgptech.api.myrestapi.application.dto.IO.CanaisIO;
import com.mgptech.api.myrestapi.application.dto.response.CanaisDtoResponse;
import com.mgptech.api.myrestapi.application.service.*;
import com.mgptech.api.myrestapi.domain.entities.Canais;
import com.mgptech.api.myrestapi.services.mapper.ObjectMapperUtils;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.util.List;

@RestController()
@RequestMapping("/api/canal")
@CrossOrigin(origins = "http://localhost:8080")
public class CanaisController {

    @Autowired
    private CanaisService _canaisService;

    @Autowired
    ObjectMapperUtils objectMapperUtils ;

    @Autowired
    CanaisIO canaisIO;

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
    public ResponseEntity<Canais> add(@RequestBody CanaisDtoRequest canaisDtoRequire) throws Exception{
        Canais canalModel = canaisIO.mapTo(canaisDtoRequire);
        Canais savedCanais = _canaisService.create(canalModel);
        return new ResponseEntity<>(savedCanais, HttpStatus.CREATED);
    }

    @RequestMapping( method =  RequestMethod.PUT)
    public ResponseEntity<Canais> update(@RequestBody CanaisDtoRequest canaisDtoRequire) throws Exception {

        Canais canaisModel = canaisIO.mapTo(canaisDtoRequire);
        Long id = canaisModel.getId();
        Canais savedCanal = _canaisService.update(id,canaisModel);
        return new ResponseEntity<>(savedCanal, HttpStatus.OK);
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id){
        _canaisService.delete(id);
        return new ResponseEntity<>("ID: "+id+" deletado.", HttpStatus.OK);
    }

}
