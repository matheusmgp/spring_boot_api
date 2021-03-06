package com.mgptech.api.myrestapi.services.controllers;

import com.mgptech.api.myrestapi.application.dto.IO.PendenciaIO;
import com.mgptech.api.myrestapi.application.dto.request.PendenciaDtoRequest;
import com.mgptech.api.myrestapi.application.dto.response.PendenciaDtoResponse;
import com.mgptech.api.myrestapi.application.service.*;
import com.mgptech.api.myrestapi.domain.entities.*;
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
@RequestMapping("/api/pendencia")
public class PendenciaController {

    private PendenciaService _pendenciaService;
    private CanaisService _canaisService;
    private CategoriaService _categoriaService;
    private SubCategoriaService _subCategoriaService;
    private ChamadoService _chamadoService;
    private UsuarioService _usuarioService;
    ObjectMapperUtils objectMapperUtils ;
    PendenciaIO pendenciaIO;

    public PendenciaController(PendenciaService _pendenciaService, CanaisService _canaisService, CategoriaService _categoriaService, SubCategoriaService _subCategoriaService, ChamadoService _chamadoService, UsuarioService _usuarioService, ObjectMapperUtils objectMapperUtils, PendenciaIO pendenciaIO) {
        this._pendenciaService = _pendenciaService;
        this._canaisService = _canaisService;
        this._categoriaService = _categoriaService;
        this._subCategoriaService = _subCategoriaService;
        this._chamadoService = _chamadoService;
        this._usuarioService = _usuarioService;
        this.objectMapperUtils = objectMapperUtils;
        this.pendenciaIO = pendenciaIO;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<PendenciaDtoResponse> getById(@PathVariable(value = "id") long id){
        PendenciaDtoResponse pendenciaDtoResponse = objectMapperUtils.mapTo(_pendenciaService.findById(id), PendenciaDtoResponse.class);
        return new ResponseEntity<>(pendenciaDtoResponse, HttpStatus.OK);
    }

    @RequestMapping( method = RequestMethod.GET)
    public ResponseEntity<List<PendenciaDtoResponse>> findAll(){
        Type type = new TypeToken<List<PendenciaDtoResponse>>() {}.getType();
        List<PendenciaDtoResponse> result = objectMapperUtils.toList(_pendenciaService.findAll(), type);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @RequestMapping( method =  RequestMethod.POST)
    public ResponseEntity<Pendencia> add(@Valid  @RequestBody PendenciaDtoRequest pendenciaDtoRequest) throws Exception{
        Canais canal = _canaisService.findById(pendenciaDtoRequest.getCanal_id());
        Usuario usuario = _usuarioService.findById(pendenciaDtoRequest.getUsuario_id());
        Categoria categoria = _categoriaService.findById(pendenciaDtoRequest.getCategoria_id());
        SubCategoria subCategoria = _subCategoriaService.findById(pendenciaDtoRequest.getSubCategoria_id());
        Chamado chamado = _chamadoService.findById(pendenciaDtoRequest.getChamado_id());

        Pendencia pendenciaModel = pendenciaIO.mapTo(pendenciaDtoRequest);
        pendenciaModel.setUsuario(usuario);
        pendenciaModel.setCanal(canal);
        pendenciaModel.setCategoria(categoria);
        pendenciaModel.setSubCategoria(subCategoria);
        pendenciaModel.setChamado(chamado);
        if (pendenciaDtoRequest.getUsuario_id_finish() != null){
            Usuario usuario_id_finish = _usuarioService.findById(pendenciaDtoRequest.getUsuario_id_finish());
            pendenciaModel.setUsuario_finish(usuario_id_finish);
        }
        Pendencia savedPendencia = _pendenciaService.create(pendenciaModel);
        return new ResponseEntity<>(savedPendencia, HttpStatus.CREATED);
    }

    @RequestMapping( method =  RequestMethod.PUT)
    public ResponseEntity<Pendencia> update(@Valid @RequestBody PendenciaDtoRequest pendenciaDtoRequest) throws Exception {
        Canais canal = _canaisService.findById(pendenciaDtoRequest.getCanal_id());
        Usuario usuario = _usuarioService.findById(pendenciaDtoRequest.getUsuario_id());
        Categoria categoria = _categoriaService.findById(pendenciaDtoRequest.getCategoria_id());
        SubCategoria subCategoria = _subCategoriaService.findById(pendenciaDtoRequest.getSubCategoria_id());
        Chamado chamado = _chamadoService.findById(pendenciaDtoRequest.getChamado_id());

        Pendencia pendenciaModel = pendenciaIO.mapTo(pendenciaDtoRequest);
        pendenciaModel.setUsuario(usuario);
        pendenciaModel.setCanal(canal);
        pendenciaModel.setCategoria(categoria);
        pendenciaModel.setSubCategoria(subCategoria);
        pendenciaModel.setChamado(chamado);
        if (pendenciaDtoRequest.getUsuario_id_finish() != null){
            Usuario usuario_id_finish = _usuarioService.findById(pendenciaDtoRequest.getUsuario_id_finish());
            pendenciaModel.setUsuario_finish(usuario_id_finish);
        }
        Long id = pendenciaModel.getId();
        Pendencia savedPendencia = _pendenciaService.update(id,pendenciaModel);
        return new ResponseEntity<>(savedPendencia, HttpStatus.OK);
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id){
        _pendenciaService.delete(id);
        return new ResponseEntity<>("ID: "+id+" deletado.", HttpStatus.OK);
    }

}
