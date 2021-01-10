package com.mgptech.api.myrestapi.application.service;

import com.mgptech.api.myrestapi.domain.entities.Filial;
import com.mgptech.api.myrestapi.domain.entities.Pendencia;
import com.mgptech.api.myrestapi.domain.entities.SubCategoria;
import com.mgptech.api.myrestapi.domain.interfaces.repositories.IPendenciaRepository;
import com.mgptech.api.myrestapi.services.controllers.exceptions.EntityNotCreatedException;
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

    public Pendencia create(Pendencia pendencia) {
        try {
            Pendencia savedPendencia =  _pendenciaRepository.save(pendencia);
        }catch (RuntimeException ex) {
            new EntityNotCreatedException("Could not create entity");
        }
        return pendencia;
    }

    public Long delete(Long id) {
        _pendenciaRepository.deleteById(id);
        return id;
    }

    public Pendencia update(Long id,Pendencia newPendencia) throws Exception {
        Pendencia pendencia = _pendenciaRepository.getOne(id);
        if (pendencia == null) {
            throw new Exception();
        }
        if (pendencia.getId() != id) {
            throw new IllegalArgumentException();
        }

        newPendencia.setId(id);
        Pendencia pendenciaDB = _pendenciaRepository.save(newPendencia);
        return pendenciaDB;
    }
}


