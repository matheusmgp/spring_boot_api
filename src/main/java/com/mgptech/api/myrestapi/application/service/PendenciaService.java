package com.mgptech.api.myrestapi.application.service;

import com.mgptech.api.myrestapi.domain.entities.Pendencia;
import com.mgptech.api.myrestapi.domain.interfaces.repositories.IPendenciaRepository;
import com.mgptech.api.myrestapi.services.controllers.exceptions.EntityNotFoundException;
import com.mgptech.api.myrestapi.services.interfaces.IPendenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PendenciaService implements IPendenciaService {

    @Autowired
    private IPendenciaRepository _pendenciaRepository;

    public PendenciaService(IPendenciaRepository _pendenciaRepository) {
        this._pendenciaRepository = _pendenciaRepository;
    }

    public List<Pendencia> findAll() {
        return _pendenciaRepository.findAll();

    }

    public Pendencia findById(Long id) {
        return  _pendenciaRepository.findById(id) .orElseThrow(
                () -> new EntityNotFoundException("ID not found "+ id));
    }



    public Long delete(Long id) {
        _pendenciaRepository.deleteById(id);
        return id;
    }

    public Pendencia create(Pendencia pendencia) {
        return  _pendenciaRepository.save(pendencia);
    }


    public Pendencia update(Long id,Pendencia pendenciaUpdated) {
        pendenciaUpdated.setId(id);
        return _pendenciaRepository.save(pendenciaUpdated);

    }
}


