package com.mgptech.api.myrestapi.services.controllers;


import com.mgptech.api.myrestapi.application.dto.IO.SubCategoriaIO;
import com.mgptech.api.myrestapi.application.dto.SubCategoriaDto;
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

import java.lang.reflect.Type;
import java.util.List;

@RestController()
@RequestMapping("/api/subCategoria")
public class SubCategoriaController {
    @Autowired
    private SubCategoriaService _subCategoriaService;

    @Autowired
    private CategoriaService _categoriaService;

    @Autowired
    ObjectMapperUtils objectMapperUtils ;

    @Autowired
    SubCategoriaIO subCategoriaIO;


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<SubCategoriaDtoResponse> getById(@PathVariable(value = "id") long id){
        SubCategoriaDtoResponse subCategoriaDtoResponse = objectMapperUtils.mapTo(_subCategoriaService.findById(id), SubCategoriaDtoResponse.class);
        return new ResponseEntity<>(subCategoriaDtoResponse, HttpStatus.OK);
    }

    @RequestMapping( method =  RequestMethod.POST)
    public ResponseEntity<SubCategoria> add(@RequestBody SubCategoriaDto subCategoriaDto){
        Categoria categoria = _categoriaService.findById(subCategoriaDto.getCategoria_id());

        SubCategoria subCategoriaModel = subCategoriaIO.mapTo(subCategoriaDto);
        subCategoriaModel.setCategoria(categoria);
        SubCategoria savedSubCategoria = _subCategoriaService.create(subCategoriaModel);
        return new ResponseEntity<SubCategoria>(savedSubCategoria, HttpStatus.CREATED);
    }

    @RequestMapping( method = RequestMethod.GET)
    public ResponseEntity<List<SubCategoriaDtoResponse>> findAll(){
        Type type = new TypeToken<List<SubCategoriaDtoResponse>>() {}.getType();

        List<SubCategoriaDtoResponse> result = objectMapperUtils.toList(_subCategoriaService.findAll(), type);
        return new ResponseEntity<List<SubCategoriaDtoResponse>>(result, HttpStatus.OK);
    }

    @RequestMapping( method =  RequestMethod.PUT)
    public ResponseEntity<SubCategoria> update(@RequestBody SubCategoriaDto subCategoriaDto) throws Exception{
        Categoria categoria = _categoriaService.findById(subCategoriaDto.getCategoria_id());

        SubCategoria subCategoriaModel = subCategoriaIO.mapTo(subCategoriaDto);
        subCategoriaModel.setCategoria(categoria);
        Long id = subCategoriaModel.getId();
        SubCategoria savedSubCategoria = _subCategoriaService.update(id,subCategoriaModel);
        return new ResponseEntity<SubCategoria>(savedSubCategoria, HttpStatus.OK);
    }
    @DeleteMapping(path = "{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id){
        _subCategoriaService.delete(id);
        return new ResponseEntity<String>("ID: "+id+" deletado.", HttpStatus.OK);
    }



}


