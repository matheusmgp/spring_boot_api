package com.mgptech.api.myrestapi.application.service;

import com.mgptech.api.myrestapi.application.dto.request.UsuarioDtoRequest;
import com.mgptech.api.myrestapi.domain.entities.Usuario;
import com.mgptech.api.myrestapi.domain.interfaces.repositories.IUsuarioRepository;
import com.mgptech.api.myrestapi.services.controllers.exceptions.ExistingEmailException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRegistrationService {
    private UsuarioService usuarioService;
    private TokenService tokenService;
    private IUsuarioRepository _usuarioRepository;

    @Autowired
    public UserRegistrationService(UsuarioService usuarioService, TokenService tokenService,IUsuarioRepository usuarioRepository){
        this.usuarioService = usuarioService;
        this.tokenService = tokenService;
        this._usuarioRepository=usuarioRepository;
    }

    public Usuario registrate(Usuario user){
        user.setToken(tokenService.generateToken(user));

        return _usuarioRepository.save(user);
    }



}
