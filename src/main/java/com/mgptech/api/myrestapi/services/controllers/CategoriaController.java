package com.mgptech.api.myrestapi.services.controllers;

import com.mgptech.api.myrestapi.application.dto.CategoriaDto;
import com.mgptech.api.myrestapi.application.dto.ChamadoDto;
import com.mgptech.api.myrestapi.application.dto.IO.CategoriaIO;
import com.mgptech.api.myrestapi.application.dto.output.CategoriaDtoOutput;
import com.mgptech.api.myrestapi.application.dto.output.ChamadoDtoOutput;
import com.mgptech.api.myrestapi.application.service.CategoriaService;
import com.mgptech.api.myrestapi.domain.entities.Categoria;
import com.mgptech.api.myrestapi.domain.entities.Chamado;
import com.mgptech.api.myrestapi.services.mapper.ObjectMapperUtils;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.util.List;

@RestController()
@RequestMapping("/api/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaService _categoriaService;



    @Autowired
    ObjectMapperUtils objectMapperUtils ;

    @Autowired
    CategoriaIO categoriaIO;


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<CategoriaDtoOutput> getById(@PathVariable(value = "id") long id){
        CategoriaDtoOutput categoriaDtoOutput = objectMapperUtils.mapTo(_categoriaService.findById(id), CategoriaDtoOutput.class);
        // return ResponseEntity.ok(chamadoDtoOutput);
        return new ResponseEntity<>(categoriaDtoOutput, HttpStatus.OK);
    }

    @RequestMapping( method =  RequestMethod.POST)
    public ResponseEntity<Categoria> add(@RequestBody CategoriaDto categoriaDto){
        Categoria categoriaModel = categoriaIO.mapTo(categoriaDto);
        Categoria savedCategoria = _categoriaService.create(categoriaModel);
        return new ResponseEntity<Categoria>(savedCategoria, HttpStatus.CREATED);
    }



    @RequestMapping( method = RequestMethod.GET)
    public ResponseEntity<List<CategoriaDtoOutput>> findAll(){
        Type type = new TypeToken<List<CategoriaDtoOutput>>() {}.getType();

        List<CategoriaDtoOutput> result = objectMapperUtils.toList(_categoriaService.findAll(), type);
        return new ResponseEntity<List<CategoriaDtoOutput>>(result, HttpStatus.OK);
    }


    @RequestMapping( method =  RequestMethod.PUT)
    public ResponseEntity<Categoria> update(@RequestBody CategoriaDto categoriaDto) throws Exception{
        Categoria categoriaModel = categoriaIO.mapTo(categoriaDto);
        Long id = categoriaModel.getId();
        Categoria savedCategoria = _categoriaService.update(id,categoriaModel);
        return new ResponseEntity<Categoria>(savedCategoria, HttpStatus.OK);
    }
    @DeleteMapping(path = "{id}")
    public void delete(@PathVariable("id") Long id){
        _categoriaService.delete(id);
    }

}

