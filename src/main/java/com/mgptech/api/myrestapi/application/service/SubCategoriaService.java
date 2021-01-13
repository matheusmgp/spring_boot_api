package com.mgptech.api.myrestapi.application.service;

import com.mgptech.api.myrestapi.domain.entities.Canais;
import com.mgptech.api.myrestapi.domain.entities.Setor;
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



    public Long delete(Long id) {
        _subCategoriaRepository.deleteById(id);
        return id;
    }

    public SubCategoria create(SubCategoria subCategoria) {
        return  _subCategoriaRepository.save(subCategoria);
    }


    public SubCategoria update(Long id,SubCategoria subCategoriaUpdated) {
        subCategoriaUpdated.setId(id);
        return _subCategoriaRepository.save(subCategoriaUpdated);

    }


}

