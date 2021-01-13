package com.mgptech.api.myrestapi.services.controllers;

import com.mgptech.api.myrestapi.application.dto.DadosLogin;
import com.mgptech.api.myrestapi.application.dto.request.UserAuthenticatedDto;
import com.mgptech.api.myrestapi.application.service.UserAuthenticationService;
import com.mgptech.api.myrestapi.domain.entities.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthenticationController {
    private UserAuthenticationService userAuthenticationService;

    @Autowired
    public AuthenticationController(UserAuthenticationService userAuthenticationService){
        this.userAuthenticationService = userAuthenticationService;
    }

    public AuthenticationController(){

    }


    @PostMapping("login")
    public ResponseEntity<UserAuthenticatedDto> autenticar(@RequestBody DadosLogin dadosLogin, @RequestHeader String Authorization){
        Usuario user = userAuthenticationService.authenticate(dadosLogin, Authorization);
        return new ResponseEntity<>(UserAuthenticatedDto.toDTO(user, "Bearer "), HttpStatus.ACCEPTED);
    }
}
