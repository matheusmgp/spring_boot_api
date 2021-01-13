package com.mgptech.api.myrestapi.application.service;

import com.mgptech.api.myrestapi.domain.entities.Canais;
import com.mgptech.api.myrestapi.domain.entities.Filial;
import com.mgptech.api.myrestapi.domain.interfaces.repositories.ICanaisRepository;
import com.mgptech.api.myrestapi.domain.interfaces.repositories.IFilialRepository;
import com.mgptech.api.myrestapi.services.controllers.exceptions.EntityNotCreatedException;
import com.mgptech.api.myrestapi.services.controllers.exceptions.EntityNotFoundException;
import com.mgptech.api.myrestapi.services.controllers.exceptions.EntityNotUpdatedException;
import com.mgptech.api.myrestapi.services.interfaces.ICanaisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CanaisService implements ICanaisService {

    @Autowired
    private ICanaisRepository _canaisRepository;

    public CanaisService(ICanaisRepository _canaisRepository) {
        this._canaisRepository = _canaisRepository;
    }

    public List<Canais> findAll() {
        return _canaisRepository.findAll();

    }

    public Canais findById(Long id) {
        return  _canaisRepository.findById(id) .orElseThrow(
                () -> new EntityNotFoundException("ID not found "+ id));
    }

    public Canais create(Canais canal) {
        try {
            Canais savedCanal =  _canaisRepository.save(canal);
        }catch (RuntimeException ex) {
            new EntityNotCreatedException("Could not create entity");
        }
        return canal;
    }

    public Long delete(Long id) {
        _canaisRepository.deleteById(id);
        return id;
    }

    public Canais update(Long id,Canais newCanal) throws Exception {
         Canais updatedCanal = new Canais();
        Canais canal =  _canaisRepository.findById(id) .orElseThrow(
                () -> new EntityNotFoundException("ID not found "+ id));

      //  Canais canal = _canaisRepository.getOne(id);
        //if (canal == null) {
        //    throw new Exception();
       // }
        if (canal.getId() != id) {
            throw new IllegalArgumentException();
        }

        newCanal.setId(id);
        try {
            updatedCanal = _canaisRepository.save(newCanal);
        }catch (RuntimeException ex) {
            new EntityNotUpdatedException("Could not update entity");
        }

        return updatedCanal;
    }
    public Boolean exists(Long id){
        return _canaisRepository.existsById(id);
    }
}

