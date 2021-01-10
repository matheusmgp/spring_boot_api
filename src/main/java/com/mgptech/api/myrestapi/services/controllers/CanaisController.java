package com.mgptech.api.myrestapi.services.controllers;


import com.mgptech.api.myrestapi.application.dto.CanaisDto;
import com.mgptech.api.myrestapi.application.dto.IO.CanaisIO;
import com.mgptech.api.myrestapi.application.dto.output.CanaisDtoOutput;
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
public class CanaisController {

    @Autowired
    private CanaisService _canaisService;

    @Autowired
    ObjectMapperUtils objectMapperUtils ;

    @Autowired
    CanaisIO canaisIO;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<CanaisDtoOutput> getById(@PathVariable(value = "id") long id){
        CanaisDtoOutput canaisDtoOutput = objectMapperUtils.mapTo(_canaisService.findById(id), CanaisDtoOutput.class);
        return new ResponseEntity<>(canaisDtoOutput, HttpStatus.OK);
    }

    @RequestMapping( method = RequestMethod.GET)
    public ResponseEntity<List<CanaisDtoOutput>> findAll(){
        Type type = new TypeToken<List<CanaisDtoOutput>>() {}.getType();
        List<CanaisDtoOutput> result = objectMapperUtils.toList(_canaisService.findAll(), type);
        return new ResponseEntity<List<CanaisDtoOutput>>(result, HttpStatus.OK);
    }

    @RequestMapping( method =  RequestMethod.POST)
    public ResponseEntity<Canais> add(@RequestBody CanaisDto canaisDto) throws Exception{
        Canais canalModel = canaisIO.mapTo(canaisDto);
        Canais savedCanais = _canaisService.create(canalModel);
        return new ResponseEntity<Canais>(savedCanais, HttpStatus.CREATED);
    }

    @RequestMapping( method =  RequestMethod.PUT)
    public ResponseEntity<Canais> update(@RequestBody CanaisDto canaisDto) throws Exception {

        Canais canaisModel = canaisIO.mapTo(canaisDto);
        Long id = canaisModel.getId();
        Canais savedCanal = _canaisService.update(id,canaisModel);
        return new ResponseEntity<Canais>(savedCanal, HttpStatus.OK);
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id){
        _canaisService.delete(id);
        return new ResponseEntity<String>("ID: "+id+" deletado.", HttpStatus.OK);
    }

}
