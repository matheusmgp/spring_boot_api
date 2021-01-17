package com.mgptech.api.myrestapi.services.controllers;

import java.util.List;

import com.mgptech.api.myrestapi.application.dto.response.ChamadoDtoResponse;
import com.mgptech.api.myrestapi.application.service.FilialService;
import com.mgptech.api.myrestapi.application.service.SetorService;
import com.mgptech.api.myrestapi.application.service.UsuarioService;
import com.mgptech.api.myrestapi.domain.entities.Filial;
import com.mgptech.api.myrestapi.domain.entities.Setor;
import com.mgptech.api.myrestapi.domain.entities.Usuario;
import org.modelmapper.TypeToken;
import java.lang.reflect.Type;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mgptech.api.myrestapi.application.dto.request.ChamadoDtoRequest;
import com.mgptech.api.myrestapi.application.dto.IO.ChamadoIO;
import com.mgptech.api.myrestapi.application.service.ChamadoService;
import com.mgptech.api.myrestapi.domain.entities.Chamado;
import com.mgptech.api.myrestapi.services.mapper.ObjectMapperUtils;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/chamado")
public class ChamadoController {


	private ChamadoService _chamadoService;
    private SetorService _setorService;
    private FilialService _filialService;
    private UsuarioService _usuarioService;
	ObjectMapperUtils  objectMapperUtils ;
    ChamadoIO chamadoIO;

    public ChamadoController(ChamadoService _chamadoService, SetorService _setorService, FilialService _filialService, UsuarioService _usuarioService, ObjectMapperUtils objectMapperUtils, ChamadoIO chamadoIO) {
        this._chamadoService = _chamadoService;
        this._setorService = _setorService;
        this._filialService = _filialService;
        this._usuarioService = _usuarioService;
        this.objectMapperUtils = objectMapperUtils;
        this.chamadoIO = chamadoIO;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<ChamadoDtoResponse> getById(@PathVariable(value = "id") long id){
        ChamadoDtoResponse chamadoDtoResponse = objectMapperUtils.mapTo(_chamadoService.findById(id), ChamadoDtoResponse.class);
        return new ResponseEntity<>(chamadoDtoResponse, HttpStatus.OK);
	}

	@RequestMapping( method = RequestMethod.GET)
    public ResponseEntity<List<ChamadoDtoResponse>> findAll(){
        Type type = new TypeToken<List<ChamadoDtoResponse>>() {}.getType();
        List<ChamadoDtoResponse> result = objectMapperUtils.toList(_chamadoService.findAll(), type);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @RequestMapping( method =  RequestMethod.POST)
    public ResponseEntity<Chamado> add(@Valid @RequestBody ChamadoDtoRequest chamadoDtoRequire) throws Exception{
	   Setor setor = _setorService.findById(chamadoDtoRequire.getSetor());
       Usuario usuario = _usuarioService.findById(chamadoDtoRequire.getUsuario());
       Filial filial = _filialService.findById(chamadoDtoRequire.getFilial());


       Chamado chamadoModel = chamadoIO.mapTo(chamadoDtoRequire);
       chamadoModel.setSetor(setor);
       chamadoModel.setFilial(filial);
       chamadoModel.setUsuario(usuario);
        if (chamadoDtoRequire.getUsuario_id_finish() != null){
            Usuario usuario_finish = _usuarioService.findById(chamadoDtoRequire.getUsuario_id_finish());
            chamadoModel.setUsuario_finish(usuario_finish);
        }
        if (chamadoDtoRequire.getUsuario_id_redirect() != null){
            Usuario usuario_redirect = _usuarioService.findById(chamadoDtoRequire.getUsuario_id_redirect());
            chamadoModel.setUsuario_redirect(usuario_redirect);
        }
        Chamado savedChamado = _chamadoService.create(chamadoModel);
        return new ResponseEntity<>(savedChamado, HttpStatus.CREATED);
    }

    @RequestMapping( method =  RequestMethod.PUT)
    public ResponseEntity<Chamado> update(@Valid @RequestBody ChamadoDtoRequest chamadoDtoRequire) throws Exception {

        Setor setor = _setorService.findById(chamadoDtoRequire.getSetor());
        Usuario usuario = _usuarioService.findById(chamadoDtoRequire.getUsuario());
        Filial filial = _filialService.findById(chamadoDtoRequire.getFilial());

        Chamado chamadoModel = chamadoIO.mapTo(chamadoDtoRequire);
        chamadoModel.setSetor(setor);
        chamadoModel.setFilial(filial);
        chamadoModel.setUsuario(usuario);
        if (chamadoDtoRequire.getUsuario_id_finish() != null){
            Usuario usuario_finish = _usuarioService.findById(chamadoDtoRequire.getUsuario_id_finish());
            chamadoModel.setUsuario_finish(usuario_finish);
        }
        if (chamadoDtoRequire.getUsuario_id_redirect() != null){
            Usuario usuario_redirect = _usuarioService.findById(chamadoDtoRequire.getUsuario_id_redirect());
            chamadoModel.setUsuario_redirect(usuario_redirect);
        }
        Long id = chamadoModel.getId();
        Chamado savedChamado = _chamadoService.update(id,chamadoModel);
        return new ResponseEntity<>(savedChamado, HttpStatus.OK);
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id){
    	  _chamadoService.delete(id);
    	  return new ResponseEntity<>("ID: "+id+" deletado.", HttpStatus.OK);
    }
	
}
