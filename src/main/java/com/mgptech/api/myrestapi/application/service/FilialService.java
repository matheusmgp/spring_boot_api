/**
 * 
 */
package com.mgptech.api.myrestapi.application.service;

import java.util.List;
import java.util.Optional;

import com.mgptech.api.myrestapi.services.controllers.exceptions.EntityNotFoundException;
import org.springframework.stereotype.Service;

import com.mgptech.api.myrestapi.domain.entities.Filial;
import com.mgptech.api.myrestapi.domain.interfaces.repositories.IFilialRepository;
import com.mgptech.api.myrestapi.services.interfaces.IFilialService;

/**
 * @author matheus
 *
 */
@Service
public class FilialService implements IFilialService{


	private IFilialRepository _filialRepository;

    public FilialService(IFilialRepository repository) {

        _filialRepository = repository;
    }
    
   

    public List<Filial> findAll() {
        return _filialRepository.findAll();

    }

    public Filial findById(Long id) {
        return  _filialRepository.findById(id) .orElseThrow(
                () -> new EntityNotFoundException("ID not found "+ id));
    }


    public Long delete(Long id) {
    	_filialRepository.deleteById(id);
    	return id;
    }

    public Filial create(Filial filial) {
        return  _filialRepository.save(filial);
    }


    public Filial update(Long id,Filial filialUpdated) {
        filialUpdated.setId(id);
        return _filialRepository.save(filialUpdated);
    }

    public Boolean cnpjExists(String cnpj){
        var retorno = _filialRepository.findByCnpj(cnpj);
        if(!retorno.isEmpty()){
            return true;
        }else{
            return false;
        }
    }
}


