package com.mgptech.api.myrestapi.services.controllers;


import com.mgptech.api.myrestapi.application.dto.CategoriaDto;
import com.mgptech.api.myrestapi.application.dto.IO.CategoriaIO;
import com.mgptech.api.myrestapi.application.dto.IO.SetorIO;
import com.mgptech.api.myrestapi.application.dto.SetorDto;
import com.mgptech.api.myrestapi.application.dto.output.CategoriaDtoOutput;
import com.mgptech.api.myrestapi.application.dto.output.SetorDtoOutput;
import com.mgptech.api.myrestapi.application.service.CategoriaService;
import com.mgptech.api.myrestapi.application.service.SetorService;
import com.mgptech.api.myrestapi.domain.entities.Categoria;
import com.mgptech.api.myrestapi.domain.entities.Setor;
import com.mgptech.api.myrestapi.services.mapper.ObjectMapperUtils;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.util.List;

@RestController
@RequestMapping("/api/setor")
public class SetorController {
    @Autowired
    private SetorService _setorService;

    @Autowired
    ObjectMapperUtils objectMapperUtils ;

    @Autowired
    SetorIO setorIO;


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<SetorDtoOutput> getById(@PathVariable(value = "id") long id){
        SetorDtoOutput setorDtoOutput = objectMapperUtils.mapTo(_setorService.findById(id), SetorDtoOutput.class);
        // return ResponseEntity.ok(chamadoDtoOutput);
        return new ResponseEntity<>(setorDtoOutput, HttpStatus.OK);
    }

    @RequestMapping( method =  RequestMethod.POST)
    public ResponseEntity<Setor> add(@RequestBody SetorDto setorDto){
        Setor setorModel = setorIO.mapTo(setorDto);
        Setor savedSetor = _setorService.create(setorModel);
        return new ResponseEntity<Setor>(savedSetor, HttpStatus.CREATED);
    }



    @RequestMapping( method = RequestMethod.GET)
    public ResponseEntity<List<SetorDtoOutput>> findAll(){
        Type type = new TypeToken<List<SetorDtoOutput>>() {}.getType();

        List<SetorDtoOutput> result = objectMapperUtils.toList(_setorService.findAll(), type);
        return new ResponseEntity<List<SetorDtoOutput>>(result, HttpStatus.OK);
    }


    @RequestMapping( method =  RequestMethod.PUT)
    public ResponseEntity<Setor> update(@RequestBody SetorDto setorDto) throws Exception{
        Setor setorModel = setorIO.mapTo(setorDto);
        Long id = setorModel.getId();
        Setor savedSetor = _setorService.update(id,setorModel);
        return new ResponseEntity<Setor>(savedSetor, HttpStatus.OK);
    }
    @DeleteMapping(path = "{id}")
    public void delete(@PathVariable("id") Long id){
        _setorService.delete(id);
    }

}

