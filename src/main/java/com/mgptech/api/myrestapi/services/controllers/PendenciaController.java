package com.mgptech.api.myrestapi.services.controllers;

import com.mgptech.api.myrestapi.application.dto.IO.PendenciaIO;
import com.mgptech.api.myrestapi.application.dto.PendenciaDto;
import com.mgptech.api.myrestapi.application.dto.response.PendenciaDtoResponse;
import com.mgptech.api.myrestapi.application.service.*;
import com.mgptech.api.myrestapi.domain.entities.*;
import com.mgptech.api.myrestapi.services.mapper.ObjectMapperUtils;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.util.List;

@RestController
@RequestMapping("/api/pendencia")
public class PendenciaController {
    @Autowired
    private PendenciaService _pendenciaService;

    @Autowired
    private CanaisService _canaisService;

    @Autowired
    private CategoriaService _categoriaService;

    @Autowired
    private SubCategoriaService _subCategoriaService;

    @Autowired
    private ChamadoService _chamadoService;

    @Autowired
    private UsuarioService _usuarioService;

    @Autowired
    ObjectMapperUtils objectMapperUtils ;

    @Autowired
    PendenciaIO pendenciaIO;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<PendenciaDtoResponse> getById(@PathVariable(value = "id") long id){
        PendenciaDtoResponse pendenciaDtoResponse = objectMapperUtils.mapTo(_pendenciaService.findById(id), PendenciaDtoResponse.class);
        return new ResponseEntity<>(pendenciaDtoResponse, HttpStatus.OK);
    }

    @RequestMapping( method = RequestMethod.GET)
    public ResponseEntity<List<PendenciaDtoResponse>> findAll(){
        Type type = new TypeToken<List<PendenciaDtoResponse>>() {}.getType();
        List<PendenciaDtoResponse> result = objectMapperUtils.toList(_pendenciaService.findAll(), type);
        return new ResponseEntity<List<PendenciaDtoResponse>>(result, HttpStatus.OK);
    }

    @RequestMapping( method =  RequestMethod.POST)
    public ResponseEntity<Pendencia> add(@RequestBody PendenciaDto pendenciaDto) throws Exception{
        Canais canal = _canaisService.findById(pendenciaDto.getCanal_id());
        Usuario usuario = _usuarioService.findById(pendenciaDto.getUsuario_id());
        Categoria categoria = _categoriaService.findById(pendenciaDto.getCategoria_id());
        SubCategoria subCategoria = _subCategoriaService.findById(pendenciaDto.getSubCategoria_id());
        Chamado chamado = _chamadoService.findById(pendenciaDto.getChamado_id());

        Pendencia pendenciaModel = pendenciaIO.mapTo(pendenciaDto);
        pendenciaModel.setUsuario(usuario);
        pendenciaModel.setCanal(canal);
        pendenciaModel.setCategoria(categoria);
        pendenciaModel.setSubCategoria(subCategoria);
        pendenciaModel.setChamado(chamado);
        if (pendenciaDto.getUsuario_id_finish() != null){
            Usuario usuario_id_finish = _usuarioService.findById(pendenciaDto.getUsuario_id_finish());
            pendenciaModel.setUsuario_finish(usuario_id_finish);
        }
        Pendencia savedPendencia = _pendenciaService.create(pendenciaModel);
        return new ResponseEntity<Pendencia>(savedPendencia, HttpStatus.CREATED);
    }

    @RequestMapping( method =  RequestMethod.PUT)
    public ResponseEntity<Pendencia> update(@RequestBody PendenciaDto pendenciaDto) throws Exception {
        Canais canal = _canaisService.findById(pendenciaDto.getCanal_id());
        Usuario usuario = _usuarioService.findById(pendenciaDto.getUsuario_id());
        Categoria categoria = _categoriaService.findById(pendenciaDto.getCategoria_id());
        SubCategoria subCategoria = _subCategoriaService.findById(pendenciaDto.getSubCategoria_id());
        Chamado chamado = _chamadoService.findById(pendenciaDto.getChamado_id());

        Pendencia pendenciaModel = pendenciaIO.mapTo(pendenciaDto);
        pendenciaModel.setUsuario(usuario);
        pendenciaModel.setCanal(canal);
        pendenciaModel.setCategoria(categoria);
        pendenciaModel.setSubCategoria(subCategoria);
        pendenciaModel.setChamado(chamado);
        if (pendenciaDto.getUsuario_id_finish() != null){
            Usuario usuario_id_finish = _usuarioService.findById(pendenciaDto.getUsuario_id_finish());
            pendenciaModel.setUsuario_finish(usuario_id_finish);
        }
        Long id = pendenciaModel.getId();
        Pendencia savedPendencia = _pendenciaService.update(id,pendenciaModel);
        return new ResponseEntity<Pendencia>(savedPendencia, HttpStatus.OK);
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id){
        _pendenciaService.delete(id);
        return new ResponseEntity<String>("ID: "+id+" deletado.", HttpStatus.OK);
    }

}
