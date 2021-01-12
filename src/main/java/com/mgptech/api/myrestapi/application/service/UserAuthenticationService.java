package com.mgptech.api.myrestapi.application.service;

import com.mgptech.api.myrestapi.application.dto.DadosLogin;
import com.mgptech.api.myrestapi.domain.entities.Usuario;
import com.mgptech.api.myrestapi.services.controllers.exceptions.ExistingEmailException;
import com.mgptech.api.myrestapi.services.controllers.exceptions.ExpiredTokenException;
import com.mgptech.api.myrestapi.services.controllers.exceptions.InvalidLoginException;
import com.mgptech.api.myrestapi.services.controllers.exceptions.InvalidTokenException;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserAuthenticationService {

    private UsuarioService usuarioService;
    private TokenService tokenService;

    @Autowired
    public UserAuthenticationService(UsuarioService usuarioService, TokenService tokenService) {
        this.usuarioService = usuarioService;
        this.tokenService = tokenService;
    }


    public Usuario authenticate(DadosLogin dados, String token) {
        Usuario user = usuarioService.findByEmail(dados.getEmail()).orElseThrow(ExistingEmailException::new);
        if (dados.getSenha().equals(user.getSenha()) && !token.isEmpty() && validate(token)) {
            return user;
        } else {
            throw new InvalidLoginException();
        }
    }

    private boolean validate(String token) {
        try {
            String tokenTratado = token.replace("Bearer ", "");
            Claims claims = tokenService.decodeToken(tokenTratado);

            System.out.println(claims.getIssuer());
            System.out.println(claims.getIssuedAt());
            //Verifica se o token está expirado
            if (claims.getExpiration().before(new Date(System.currentTimeMillis()))) throw new ExpiredTokenException();
            System.out.println(claims.getExpiration());
            return true;
        } catch (ExpiredTokenException et) {
            et.printStackTrace();
            throw et;
        } catch (Exception e) {
            e.printStackTrace();
            throw new InvalidTokenException();
        }

    }
}
