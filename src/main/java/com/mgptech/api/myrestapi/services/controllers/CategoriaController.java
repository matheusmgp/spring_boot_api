package com.mgptech.api.myrestapi.services.controllers;

import com.mgptech.api.myrestapi.application.dto.request.CategoriaDtoRequest;
import com.mgptech.api.myrestapi.application.dto.IO.CategoriaIO;
import com.mgptech.api.myrestapi.application.dto.response.CategoriaDtoResponse;
import com.mgptech.api.myrestapi.application.service.CategoriaService;
import com.mgptech.api.myrestapi.domain.entities.Canais;
import com.mgptech.api.myrestapi.domain.entities.Categoria;
import com.mgptech.api.myrestapi.services.mapper.ObjectMapperUtils;
import org.modelmapper.TypeToken;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.lang.reflect.Type;
import java.util.List;

@RestController()
@RequestMapping("/api/categoria")
public class CategoriaController {

    private CategoriaService _categoriaService;
    ObjectMapperUtils objectMapperUtils ;
    CategoriaIO categoriaIO;

    public CategoriaController(CategoriaService _categoriaService, ObjectMapperUtils objectMapperUtils, CategoriaIO categoriaIO) {
        this._categoriaService = _categoriaService;
        this.objectMapperUtils = objectMapperUtils;
        this.categoriaIO = categoriaIO;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<CategoriaDtoResponse> getById(@PathVariable(value = "id") long id){
        CategoriaDtoResponse categoriaDtoResponse = objectMapperUtils.mapTo(_categoriaService.findById(id), CategoriaDtoResponse.class);
        // return ResponseEntity.ok(chamadoDtoOutput);
        return new ResponseEntity<>(categoriaDtoResponse, HttpStatus.OK);
    }

    @RequestMapping( method =  RequestMethod.POST)
    public ResponseEntity<Categoria> add(@Valid @RequestBody CategoriaDtoRequest categoriaDtoRequire){
        Categoria categoriaModel = categoriaIO.mapTo(categoriaDtoRequire);
        categoriaModel.setId(0);
        Categoria savedCategoria = _categoriaService.create(categoriaModel);
        return new ResponseEntity<>(savedCategoria, HttpStatus.CREATED);
    }

    @RequestMapping( method = RequestMethod.GET)
    public ResponseEntity<List<CategoriaDtoResponse>> findAll(){
        Type type = new TypeToken<List<CategoriaDtoResponse>>() {}.getType();

        List<CategoriaDtoResponse> result = objectMapperUtils.toList(_categoriaService.findAll(), type);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @RequestMapping( method =  RequestMethod.PUT)
    public ResponseEntity<Categoria> update(@Valid @RequestBody CategoriaDtoRequest categoriaDtoRequire) throws Exception{
        Categoria categoriaModel = categoriaIO.mapTo(categoriaDtoRequire);
        if(categoriaModel.getId() <= 0){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        Categoria categoriaRetorno = _categoriaService.findById(categoriaModel.getId());
        if(categoriaRetorno != null){
            Long id = categoriaModel.getId();
            Categoria savedCategoria = _categoriaService.update(id,categoriaModel);
            return new ResponseEntity<>(savedCategoria, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);

    }

    @DeleteMapping(path = "{id}")
    public void delete(@PathVariable("id") Long id){
        _categoriaService.delete(id);
    }

}

