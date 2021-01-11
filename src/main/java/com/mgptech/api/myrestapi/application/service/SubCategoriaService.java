package com.mgptech.api.myrestapi.application.service;

import com.mgptech.api.myrestapi.domain.entities.Canais;
import com.mgptech.api.myrestapi.domain.entities.SubCategoria;
import com.mgptech.api.myrestapi.domain.interfaces.repositories.ICanaisRepository;
import com.mgptech.api.myrestapi.domain.interfaces.repositories.ISubCategoriaRepository;
import com.mgptech.api.myrestapi.services.controllers.exceptions.EntityNotCreatedException;
import com.mgptech.api.myrestapi.services.controllers.exceptions.EntityNotFoundException;
import com.mgptech.api.myrestapi.services.interfaces.ISubCategoriaService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SubCategoriaService implements ISubCategoriaService {
    private ISubCategoriaRepository _subCategoriaRepository;

    public SubCategoriaService(ISubCategoriaRepository _subCategoriaRepository) {
        this._subCategoriaRepository = _subCategoriaRepository;
    }

    public List<SubCategoria> findAll() {
        return _subCategoriaRepository.findAll();

    }

    public SubCategoria findById(Long id) {
        return  _subCategoriaRepository.findById(id) .orElseThrow(
                () -> new EntityNotFoundException("ID not found "+ id));
    }

    public SubCategoria  create(SubCategoria sub) {
        try {
            SubCategoria savedSub =  _subCategoriaRepository.save(sub);
        }catch (RuntimeException ex) {
            new EntityNotCreatedException("Could not create entity");
        }
        return sub;
    }

    public Long delete(Long id) {
        _subCategoriaRepository.deleteById(id);
        return id;
    }

    public SubCategoria update(Long id,SubCategoria newSub) throws Exception {
        SubCategoria subCategoria = _subCategoriaRepository.getOne(id);
        if (subCategoria == null) {
            throw new Exception();
        }
        if (subCategoria.getId() != id) {
            throw new IllegalArgumentException();
        }

        newSub.setId(id);
        SubCategoria subCategoriaDB = _subCategoriaRepository.save(newSub);
        return subCategoriaDB;
    }


}

