package com.mgptech.api.myrestapi.services.controllers;

import com.mgptech.api.myrestapi.application.dto.request.DadosLoginRequest;
import com.mgptech.api.myrestapi.application.dto.request.UserAuthenticateDtoRequest;
import com.mgptech.api.myrestapi.application.service.UserAuthenticationService;
import com.mgptech.api.myrestapi.domain.entities.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthenticationController {
    private UserAuthenticationService userAuthenticationService;
    private org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder _bCryptPasswordEncoder;
    private PasswordEncoder _passwordEncoder;

    @Autowired
    public AuthenticationController(UserAuthenticationService userAuthenticationService,  BCryptPasswordEncoder bCryptPasswordEncoder,PasswordEncoder passwordEncoder){
        this.userAuthenticationService = userAuthenticationService;
        this._bCryptPasswordEncoder = bCryptPasswordEncoder;
        this._passwordEncoder = passwordEncoder;
    }

    public AuthenticationController(){

    }


    @PostMapping("api/auth")
    public ResponseEntity<UserAuthenticateDtoRequest> autenticar(@RequestBody DadosLoginRequest dadosLoginRequest, @RequestHeader String Authorization){

      //  var encodedPass = _passwordEncoder.encode(dadosLoginRequest.getSenha());
       // dadosLoginRequest.setSenha(encodedPass);
        Usuario user = userAuthenticationService.authenticate(dadosLoginRequest, Authorization);
        return new ResponseEntity<>(UserAuthenticateDtoRequest.toDTO(user, "Bearer "), HttpStatus.ACCEPTED);
    }
}
