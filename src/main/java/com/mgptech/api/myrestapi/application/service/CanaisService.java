package com.mgptech.api.myrestapi.application.service;

import com.mgptech.api.myrestapi.domain.entities.Canais;
import com.mgptech.api.myrestapi.domain.interfaces.repositories.ICanaisRepository;
import com.mgptech.api.myrestapi.services.controllers.exceptions.EntityNotFoundException;
import com.mgptech.api.myrestapi.services.interfaces.ICanaisService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CanaisService implements ICanaisService {


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
       // try {
           return  _canaisRepository.save(canal);
       // }catch (RuntimeException ex) {
       //     new EntityNotCreatedException("Could not create entity");
       //}
      //  return canal;
    }

    public Long delete(Long id) {
        _canaisRepository.deleteById(id);
        return id;
    }

    public Canais update(Long id,Canais canalUpdated) {

       //  Canais updatedCanal = new Canais();
       // Canais canal =  _canaisRepository.findById(id).get();// .orElseThrow(
               // () -> new EntityNotFoundException("ID not found "+ id));

      //  Canais canal = _canaisRepository.getOne(id);
        //if (canal == null) {
        //    throw new Exception();
       // }
     //   if (canal.getId() != id) {
      //      throw new IllegalArgumentException();
      //  }

        canalUpdated.setId(id);
       // try {
            return _canaisRepository.save(canalUpdated);
       // }catch (RuntimeException ex) {
           // new EntityNotUpdatedException("Could not update entity");
       // }

       // return updatedCanal;
    }

    public Boolean exists(Long id){
        return _canaisRepository.existsById(id);
    }


    @Override
    public List<Canais> findByNomeContaining(String nome) {
        return _canaisRepository.findByNomeContaining(nome);
    }
}

