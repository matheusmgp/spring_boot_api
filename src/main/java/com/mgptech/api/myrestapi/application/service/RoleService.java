package com.mgptech.api.myrestapi.application.service;

import com.mgptech.api.myrestapi.domain.entities.Canais;
import com.mgptech.api.myrestapi.domain.entities.Role;
import com.mgptech.api.myrestapi.domain.interfaces.repositories.IRoleRepository;
import com.mgptech.api.myrestapi.services.controllers.exceptions.EntityNotCreatedException;
import com.mgptech.api.myrestapi.services.controllers.exceptions.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {


    private IRoleRepository _roleRepository;

    public RoleService(IRoleRepository _roleRepository) {
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
        return  _roleRepository.save(role);
    }


    public Role update(Long id,Role roleUpdated) {
        roleUpdated.setId(id);
        return _roleRepository.save(roleUpdated);

    }

    public Long delete(Long id) {
        _roleRepository.deleteById(id);
        return id;
    }


}


