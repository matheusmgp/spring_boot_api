/**
 * 
 */
package com.mgptech.api.myrestapi.application.service;

import com.mgptech.api.myrestapi.domain.entities.Chamado;
import com.mgptech.api.myrestapi.services.controllers.exceptions.EntityNotFoundException;
import org.springframework.stereotype.Service;

import com.mgptech.api.myrestapi.domain.interfaces.repositories.IChamadoRepository;
import com.mgptech.api.myrestapi.services.interfaces.IChamadoService;

import java.util.List;

/**
 * @author matheus
 *
 */
@Service
public class ChamadoService  implements IChamadoService{

	/**
	 * 
	 */
	private IChamadoRepository _chamadoRepository;
    //@Autowired
    public ChamadoService(IChamadoRepository repository) {
        _chamadoRepository = repository;
    }

    public List<Chamado> findAll() {
        return _chamadoRepository.findAll();

    }

    public Chamado findById(Long id) {
        return  _chamadoRepository.findById(id)
                .orElseThrow(
                   () -> new EntityNotFoundException("ID not found "+ id));
    }

    public Chamado create(Chamado chamado) {
        return  _chamadoRepository.save(chamado);
    }

    public void delete(Long id) {
        _chamadoRepository.deleteById(id);
    }

    public Chamado update(Long id,Chamado newChamado) throws Exception {
        Chamado chamado = _chamadoRepository.getOne(id);
        if (chamado == null) {
            throw new Exception();
        }
        if (chamado.getId() != id) {
            throw new IllegalArgumentException();
        }

        newChamado.setId(id);
        Chamado chamadoDB = _chamadoRepository.save(newChamado);
        return chamadoDB;
    }
}
