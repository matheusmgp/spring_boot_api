package com.mgptech.api.myrestapi.services.controllers;

import com.mgptech.api.myrestapi.application.dto.IO.UsuarioIO;
import com.mgptech.api.myrestapi.application.dto.request.UserAuthenticatedDto;
import com.mgptech.api.myrestapi.application.dto.request.UserRegistrationDto;
import com.mgptech.api.myrestapi.application.dto.request.UsuarioDtoRequest;
import com.mgptech.api.myrestapi.application.service.UserRegistrationService;
import com.mgptech.api.myrestapi.domain.entities.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserRegistrationController {

    private UserRegistrationService userRegistrationService;

    @Autowired
    UsuarioIO usuarioIO;
    @Autowired
    public UserRegistrationController(UserRegistrationService userRegistrationService){
        this.userRegistrationService = userRegistrationService;
    }

    public UserRegistrationController(){

    }

    @PostMapping("user")
    public ResponseEntity<UserAuthenticatedDto> registrate(@RequestBody UserRegistrationDto userRegistrationDTO){
        Usuario user = userRegistrationService.registrate(userRegistrationDTO.toUser());

        UsuarioDtoRequest usuarioDtoRequest = usuarioIO.mapTo(user);
        return  new ResponseEntity<>(UserAuthenticatedDto.toDTO(usuarioDtoRequest, "Bearer "), HttpStatus.CREATED);
    }

}