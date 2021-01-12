package com.mgptech.api.myrestapi.services.controllers;


import com.mgptech.api.myrestapi.application.dto.IO.SetorIO;
import com.mgptech.api.myrestapi.application.dto.request.SetorDtoRequest;
import com.mgptech.api.myrestapi.application.dto.response.SetorDtoResponse;
import com.mgptech.api.myrestapi.application.service.SetorService;
import com.mgptech.api.myrestapi.domain.entities.Setor;
import com.mgptech.api.myrestapi.services.mapper.ObjectMapperUtils;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    public ResponseEntity<SetorDtoResponse> getById(@PathVariable(value = "id") long id){
        SetorDtoResponse setorDtoResponse = objectMapperUtils.mapTo(_setorService.findById(id), SetorDtoResponse.class);
        // return ResponseEntity.ok(chamadoDtoOutput);
        return new ResponseEntity<>(setorDtoResponse, HttpStatus.OK);
    }

    @RequestMapping( method =  RequestMethod.POST)
    public ResponseEntity<Setor> add( @Valid @ModelAttribute("SetorDto") @RequestBody SetorDtoRequest setorDtoRequest){
        Setor setorModel = setorIO.mapTo(setorDtoRequest);
        Setor savedSetor = _setorService.create(setorModel);
        return new ResponseEntity<>(savedSetor, HttpStatus.CREATED);
    }



    @RequestMapping( method = RequestMethod.GET)
    public ResponseEntity<List<SetorDtoResponse>> findAll(){
        Type type = new TypeToken<List<SetorDtoResponse>>() {}.getType();

        List<SetorDtoResponse> result = objectMapperUtils.toList(_setorService.findAll(), type);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }


    @RequestMapping( method =  RequestMethod.PUT)
    public ResponseEntity<Setor> update(@RequestBody SetorDtoRequest setorDtoRequest) throws Exception{
        Setor setorModel = setorIO.mapTo(setorDtoRequest);
        Long id = setorModel.getId();
        Setor savedSetor = _setorService.update(id,setorModel);
        return new ResponseEntity<>(savedSetor, HttpStatus.OK);
    }
    @DeleteMapping(path = "{id}")
    public void delete(@PathVariable("id") Long id){
        _setorService.delete(id);
    }

}

