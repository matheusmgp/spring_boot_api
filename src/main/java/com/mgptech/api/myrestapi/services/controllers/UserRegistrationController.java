package com.mgptech.api.myrestapi.services.controllers;

import com.mgptech.api.myrestapi.application.dto.request.UserAuthenticatedDto;
import com.mgptech.api.myrestapi.application.dto.request.UserRegistrationDto;
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
    public UserRegistrationController(UserRegistrationService userRegistrationService){
        this.userRegistrationService = userRegistrationService;
    }

    public UserRegistrationController(){

    }

    @PostMapping("user")
    public ResponseEntity<UserAuthenticatedDto> registrate(@RequestBody UserRegistrationDto userRegistrationDTO){
        Usuario user = userRegistrationService.registrate(userRegistrationDTO.toUser());
        return  new ResponseEntity<>(UserAuthenticatedDto.toDTO(user, "Bearer "), HttpStatus.CREATED);
    }

}
