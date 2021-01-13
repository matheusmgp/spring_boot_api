package com.mgptech.api.myrestapi.application.service;

import com.mgptech.api.myrestapi.domain.entities.Role;
import com.mgptech.api.myrestapi.domain.interfaces.repositories.IRoleRepository;
import com.mgptech.api.myrestapi.services.controllers.exceptions.EntityNotCreatedException;
import com.mgptech.api.myrestapi.services.controllers.exceptions.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IRoleService {


    private IRoleRepository _roleRepository;

    public IRoleService(IRoleRepository _roleRepository) {
        this._roleRepository = _roleRepository;
    }

    public List<Role> findAll() {
        return _roleRepository.findAll();

    }

    public Role findById(Long id) {
        return  _roleRepository.findById(id) .orElseThrow(
                () -> new EntityNotFoundException("ID not found "+ id));
    }

    public Role create(Role role) {
        try {
            Role savedRole =  _roleRepository.save(role);
        }catch (RuntimeException ex) {
            new EntityNotCreatedException("Could not create entity");
        }
        return role;
    }

    public Long delete(Long id) {
        _roleRepository.deleteById(id);
        return id;
    }

    public Role update(Long id,Role updatedRole) throws Exception {
        Role role = _roleRepository.getOne(id);
        if (role == null) {
            throw new Exception();
        }
        if (role.getId() != id) {
            throw new IllegalArgumentException();
        }

        updatedRole.setId(id);
        Role roleDB = _roleRepository.save(updatedRole);
        return roleDB;
    }
}


