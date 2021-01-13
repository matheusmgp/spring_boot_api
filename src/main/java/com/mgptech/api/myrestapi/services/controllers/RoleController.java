package com.mgptech.api.myrestapi.services.controllers;

import com.mgptech.api.myrestapi.application.dto.IO.CanaisIO;
import com.mgptech.api.myrestapi.application.dto.IO.RoleIO;
import com.mgptech.api.myrestapi.application.dto.request.CanaisDtoRequest;
import com.mgptech.api.myrestapi.application.dto.request.RoleDtoRequest;
import com.mgptech.api.myrestapi.application.dto.response.CanaisDtoResponse;
import com.mgptech.api.myrestapi.application.dto.response.RoleDtoResponse;
import com.mgptech.api.myrestapi.application.service.RoleService;
import com.mgptech.api.myrestapi.domain.entities.Canais;
import com.mgptech.api.myrestapi.domain.entities.Role;
import com.mgptech.api.myrestapi.services.mapper.ObjectMapperUtils;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/role")
public class RoleController {

    @Autowired
    private RoleService _roleService;

    @Autowired
    ObjectMapperUtils objectMapperUtils ;

    @Autowired
    RoleIO roleIO;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<RoleDtoResponse> getById(@PathVariable(value = "id") long id){
        RoleDtoResponse roleDtoResponse = objectMapperUtils.mapTo(_roleService.findById(id), RoleDtoResponse.class);
        return new ResponseEntity<>(roleDtoResponse, HttpStatus.OK);
    }

    @RequestMapping( method = RequestMethod.GET)
    public ResponseEntity<List<RoleDtoResponse>> findAll(){
        Type type = new TypeToken<List<RoleDtoResponse>>() {}.getType();
        List<RoleDtoResponse> result = objectMapperUtils.toList(_roleService.findAll(), type);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @RequestMapping( method =  RequestMethod.POST)
    public ResponseEntity<Role> add(@Valid @RequestBody RoleDtoRequest roleDtoRequest){
        Role roleModel = roleIO.mapTo(roleDtoRequest);
        roleModel.setCreatedAt(java.util.Calendar.getInstance().getTime());
        Role savedRole = _roleService.create(roleModel);
        return new ResponseEntity<>(savedRole, HttpStatus.CREATED);
    }

    @RequestMapping( method =  RequestMethod.PUT)
    public ResponseEntity<Role> update(@Valid @RequestBody RoleDtoRequest roleDtoRequest)  {

        Role roleModel = roleIO.mapTo(roleDtoRequest);
        if(roleModel.getId() <= 0){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        Role roleRetorno = _roleService.findById(roleModel.getId());
        if(roleRetorno != null){
            Long id = roleModel.getId();
            // canaisModel.setStatus(true);
            roleModel.setUpdatedAt(java.util.Calendar.getInstance().getTime());
            Role savedCanal = _roleService.update(id,roleModel);
            return new ResponseEntity<>(savedCanal, HttpStatus.OK);

        }

        return new ResponseEntity<>(null, HttpStatus.OK);

    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id){
        _roleService.delete(id);
        return new ResponseEntity<>("ID: "+id+" deletado.", HttpStatus.OK);
    }


}
