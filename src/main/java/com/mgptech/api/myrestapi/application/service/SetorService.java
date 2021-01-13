package com.mgptech.api.myrestapi.application.service;


import com.mgptech.api.myrestapi.domain.entities.Filial;
import com.mgptech.api.myrestapi.domain.entities.Pendencia;
import com.mgptech.api.myrestapi.domain.entities.Setor;
import com.mgptech.api.myrestapi.domain.interfaces.repositories.ISetorRepository;
import com.mgptech.api.myrestapi.services.controllers.exceptions.EntityNotCreatedException;
import com.mgptech.api.myrestapi.services.controllers.exceptions.EntityNotFoundException;
import com.mgptech.api.myrestapi.services.interfaces.ISetorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SetorService implements ISetorService {

    private ISetorRepository _setorRepository;

    public SetorService(ISetorRepository _setorRepository) {
        this._setorRepository = _setorRepository;
    }


    public List<Setor> findAll() {
        return _setorRepository.findAll();

    }

    public Setor findById(Long id) {
        return  _setorRepository.findById(id) .orElseThrow(
                () -> new EntityNotFoundException("ID not found "+ id));
    }


    public Long delete(Long id) {
        _setorRepository.deleteById(id);
        return id;
    }

    public Setor create(Setor setor) {
        return  _setorRepository.save(setor);
    }


    public Setor update(Long id,Setor setorUpdated) {
        setorUpdated.setId(id);
        return _setorRepository.save(setorUpdated);

    }
}



