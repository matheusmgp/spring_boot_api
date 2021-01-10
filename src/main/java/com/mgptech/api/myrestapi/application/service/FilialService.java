/**
 * 
 */
package com.mgptech.api.myrestapi.application.service;

import java.util.List;

import com.mgptech.api.myrestapi.services.controllers.exceptions.EntityNotFoundException;
import org.springframework.stereotype.Service;

import com.mgptech.api.myrestapi.application.dto.FilialDto;
import com.mgptech.api.myrestapi.domain.entities.Chamado;
import com.mgptech.api.myrestapi.domain.entities.Filial;
import com.mgptech.api.myrestapi.domain.interfaces.repositories.IChamadoRepository;
import com.mgptech.api.myrestapi.domain.interfaces.repositories.IFilialRepository;
import com.mgptech.api.myrestapi.services.interfaces.IFilialService;

/**
 * @author matheus
 *
 */
@Service
public class FilialService implements IFilialService{

	/**
	 * 
	 */
	private IFilialRepository _filialRepository;
    //@Autowired
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

    public Filial create(Filial filial) {
        return  _filialRepository.save(filial);
    }

    public void delete(Long id) {
    	_filialRepository.deleteById(id);
    }

    public Filial update(Long id,Filial newFilial) throws Exception {
    	Filial filial = _filialRepository.getOne(id);
        if (filial == null) {
            throw new Exception();
        }
        if (filial.getId() != id) {
            throw new IllegalArgumentException();
        }

        newFilial.setId(id);
        Filial FilialDB = _filialRepository.save(newFilial);
        return FilialDB;
    }
}


