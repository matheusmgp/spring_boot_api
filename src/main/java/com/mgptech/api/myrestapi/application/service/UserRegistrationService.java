package com.mgptech.api.myrestapi.application.service;

import com.mgptech.api.myrestapi.domain.entities.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRegistrationService {
    private UsuarioService usuarioService;
    private TokenService tokenService;

    @Autowired
    public UserRegistrationService(UsuarioService usuarioService, TokenService tokenService){
        this.usuarioService = usuarioService;
        this.tokenService = tokenService;
    }

    public Usuario registrate(Usuario user){
        user.setToken(tokenService.generateToken(user));

        return usuarioService.create(user);
    }

}
