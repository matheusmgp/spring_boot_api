package com.mgptech.api.myrestapi.application.service;

import com.mgptech.api.myrestapi.domain.entities.Cliente;
import com.mgptech.api.myrestapi.domain.interfaces.repositories.IClienteRepository;
import com.mgptech.api.myrestapi.services.controllers.exceptions.EntityNotFoundException;
import com.mgptech.api.myrestapi.services.interfaces.IClienteService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService implements IClienteService {
    IClienteRepository _clienteRepository;

    public ClienteService(IClienteRepository _clienteRepository) {
        this._clienteRepository = _clienteRepository;
    }

    @Override
    public List<Cliente> findAll() {
        return _clienteRepository.findAll();
    }

    @Override
    public Cliente findById(Long id) {
        return  _clienteRepository.findById(id) .orElseThrow(
                () -> new EntityNotFoundException("ID not found "+ id));
    }

    @Override
    public Cliente create(Cliente cliente) {
        return _clienteRepository.save(cliente);
    }

    @Override
    public Long delete(Long id) {
        _clienteRepository.deleteById(id);
        return id;
    }

    @Override
    public Cliente update(Long id, Cliente clienteUpdated) {
        clienteUpdated.setId(id);
        return _clienteRepository.save(clienteUpdated);
    }
}
