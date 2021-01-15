package com.mgptech.api.myrestapi.services.controllers;


import com.mgptech.api.myrestapi.application.dto.IO.SubCategoriaIO;
import com.mgptech.api.myrestapi.application.dto.request.SubCategoriaDtoRequest;
import com.mgptech.api.myrestapi.application.dto.response.SubCategoriaDtoResponse;
import com.mgptech.api.myrestapi.application.service.CategoriaService;
import com.mgptech.api.myrestapi.application.service.SubCategoriaService;
import com.mgptech.api.myrestapi.domain.entities.Categoria;
import com.mgptech.api.myrestapi.domain.entities.SubCategoria;
import com.mgptech.api.myrestapi.services.mapper.ObjectMapperUtils;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.lang.reflect.Type;
import java.util.List;

@RestController()
@RequestMapping("/api/subCategoria")
public class SubCategoriaController {

    private SubCategoriaService _subCategoriaService;
    private CategoriaService _categoriaService;
    ObjectMapperUtils objectMapperUtils ;
    SubCategoriaIO subCategoriaIO;


    public SubCategoriaController(SubCategoriaService _subCategoriaService, CategoriaService _categoriaService, ObjectMapperUtils objectMapperUtils, SubCategoriaIO subCategoriaIO) {
        this._subCategoriaService = _subCategoriaService;
        this._categoriaService = _categoriaService;
        this.objectMapperUtils = objectMapperUtils;
        this.subCategoriaIO = subCategoriaIO;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<SubCategoriaDtoResponse> getById(@PathVariable(value = "id") long id){
        SubCategoriaDtoResponse subCategoriaDtoResponse = objectMapperUtils.mapTo(_subCategoriaService.findById(id), SubCategoriaDtoResponse.class);
        return new ResponseEntity<>(subCategoriaDtoResponse, HttpStatus.OK);
    }

    @RequestMapping( method =  RequestMethod.POST)
    public ResponseEntity<SubCategoria> add(@Valid @RequestBody SubCategoriaDtoRequest subCategoriaDtoRequest){
        Categoria categoria = _categoriaService.findById(subCategoriaDtoRequest.getCategoria_id());

        SubCategoria subCategoriaModel = subCategoriaIO.mapTo(subCategoriaDtoRequest);
        subCategoriaModel.setCategoria(categoria);
        SubCategoria savedSubCategoria = _subCategoriaService.create(subCategoriaModel);
        return new ResponseEntity<>(savedSubCategoria, HttpStatus.CREATED);
    }

    @RequestMapping( method = RequestMethod.GET)
    public ResponseEntity<List<SubCategoriaDtoResponse>> findAll(){
        Type type = new TypeToken<List<SubCategoriaDtoResponse>>() {}.getType();

        List<SubCategoriaDtoResponse> result = objectMapperUtils.toList(_subCategoriaService.findAll(), type);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @RequestMapping( method =  RequestMethod.PUT)
    public ResponseEntity<SubCategoria> update(@Valid  @RequestBody SubCategoriaDtoRequest subCategoriaDtoRequest) throws Exception{
        Categoria categoria = _categoriaService.findById(subCategoriaDtoRequest.getCategoria_id());

        SubCategoria subCategoriaModel = subCategoriaIO.mapTo(subCategoriaDtoRequest);
        subCategoriaModel.setCategoria(categoria);
        Long id = subCategoriaModel.getId();
        SubCategoria savedSubCategoria = _subCategoriaService.update(id,subCategoriaModel);
        return new ResponseEntity<>(savedSubCategoria, HttpStatus.OK);
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id){
        _subCategoriaService.delete(id);
        return new ResponseEntity<>("ID: "+id+" deletado.", HttpStatus.OK);
    }



}


