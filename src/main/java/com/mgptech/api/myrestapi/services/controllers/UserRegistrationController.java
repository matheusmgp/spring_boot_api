package com.mgptech.api.myrestapi.services.controllers;

import com.mgptech.api.myrestapi.application.dto.IO.UsuarioIO;
import com.mgptech.api.myrestapi.application.dto.request.UserAuthenticateDtoRequest;
import com.mgptech.api.myrestapi.application.dto.request.UserRegistrationDtoRequest;
import com.mgptech.api.myrestapi.application.dto.request.UsuarioDtoRequest;
import com.mgptech.api.myrestapi.application.service.UserHashPasswordService;
import com.mgptech.api.myrestapi.application.service.UserRegistrationService;
import com.mgptech.api.myrestapi.application.service.UsuarioService;
import com.mgptech.api.myrestapi.domain.entities.Usuario;
import com.mgptech.api.myrestapi.services.controllers.exceptions.ExistingEmailException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserRegistrationController {

    private UserRegistrationService userRegistrationService;
    private UsuarioService _usuarioService;
    private PasswordEncoder _passwordEncoder;
    @Autowired
    UsuarioIO usuarioIO;
    @Autowired
    public UserRegistrationController(UserRegistrationService userRegistrationService,PasswordEncoder passwordEncoder,UsuarioService usuarioService){
        this.userRegistrationService = userRegistrationService;
        this._passwordEncoder = passwordEncoder;
        this._usuarioService = usuarioService;
    }

    public UserRegistrationController(){

    }

    @PostMapping("api/registration/user")
    public ResponseEntity<UserAuthenticateDtoRequest> registrate(@RequestBody UserRegistrationDtoRequest userRegistrationDTORequest){
        Usuario usuario = userRegistrationDTORequest.toUser();
        UsuarioDtoRequest usuarioDtoRequest = new UsuarioDtoRequest();
        var userEmailExists = _usuarioService.emailExists(usuario.getEmail());



        if(userEmailExists){
            Usuario usr = _usuarioService.findByEmail(usuario.getEmail()).orElseThrow(
                    () -> new ExistingEmailException("Email não encontrado"));

            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            Boolean equals = passwordEncoder.matches(userRegistrationDTORequest.getSenha(),usr.getSenha());

            if(equals){
                usuario.setId(usr.getId());
                var senhaEncoded = _passwordEncoder.encode(userRegistrationDTORequest.getSenha());
                usuario.setSenha(senhaEncoded);
                Usuario user = userRegistrationService.registrate(usuario);
                usuarioDtoRequest = usuarioIO.mapTo(user);
                return  new ResponseEntity<>(UserAuthenticateDtoRequest.toDTO(usuarioDtoRequest, "Bearer "), HttpStatus.CREATED);
            }

        }else {

        }

        return  new ResponseEntity<>(UserAuthenticateDtoRequest.toDTO(usuarioDtoRequest, "Bearer "), HttpStatus.NOT_FOUND);


    }

}
