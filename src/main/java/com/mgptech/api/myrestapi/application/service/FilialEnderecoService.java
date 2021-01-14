package com.mgptech.api.myrestapi.application.service;

import com.mgptech.api.myrestapi.domain.entities.FilialEndereco;
import com.mgptech.api.myrestapi.domain.interfaces.repositories.IFilialEnderecoRepository;
import com.mgptech.api.myrestapi.services.controllers.exceptions.EntityNotFoundException;
import com.mgptech.api.myrestapi.services.interfaces.IFilialEnderecoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilialEnderecoService implements IFilialEnderecoService {

    private IFilialEnderecoRepository _filialEnderecoRepository;

    public FilialEnderecoService(IFilialEnderecoRepository _filialEnderecoRepository) {
        this._filialEnderecoRepository = _filialEnderecoRepository;
    }

    @Override
    public List<FilialEndereco> findAll() {
        return  _filialEnderecoRepository.findAll();
    }

    @Override
    public FilialEndereco findById(Long id) {
        return _filialEnderecoRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("ID not found "+ id));
    }

    @Override
    public FilialEndereco create(FilialEndereco filialEndereco) {
        return _filialEnderecoRepository.save(filialEndereco);
    }

    @Override
    public Long delete(Long id) {
        _filialEnderecoRepository.deleteById(id);
        return id;
    }

    @Override
    public FilialEndereco update(Long id, FilialEndereco filialEndereco){
        filialEndereco.setId(id);
        return _filialEnderecoRepository.save(filialEndereco);
    }
}
