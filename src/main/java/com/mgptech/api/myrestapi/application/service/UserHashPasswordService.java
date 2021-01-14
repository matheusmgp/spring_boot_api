package com.mgptech.api.myrestapi.application.service;

import com.mgptech.api.myrestapi.application.dto.request.UsuarioDtoRequest;
import com.mgptech.api.myrestapi.domain.entities.Usuario;
import com.mgptech.api.myrestapi.services.controllers.exceptions.ExistingEmailException;
import com.mgptech.api.myrestapi.services.interfaces.IUserHashPasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserHashPasswordService implements IUserHashPasswordService {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }




}
