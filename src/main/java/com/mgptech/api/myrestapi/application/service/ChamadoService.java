/**
 * 
 */
package com.mgptech.api.myrestapi.application.service;

import com.mgptech.api.myrestapi.application.dto.request.ChamadoDtoRequest;
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
public class ChamadoService  implements IChamadoService<Chamado, ChamadoDtoRequest>{

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


    public Chamado update(Long id,Chamado chamadoUpdated) {
        chamadoUpdated.setId(id);
        return _chamadoRepository.save(chamadoUpdated);

    }

    public Long delete(Long id) {
        _chamadoRepository.deleteById(id);
        return id;
    }



    @Override
    public List<Chamado> getSetoresMesCount() {
        return null;
    }

    @Override
    public List<Chamado> getSetoresDiaCount() {
        return null;
    }

    @Override
    public List<Chamado> getEncerradosMesCount() {
        return null;
    }

    @Override
    public List<Chamado> getSEncerradosDiaCount() {
        return null;
    }

    @Override
    public List<Chamado> getEncerradosUsersMesCount() {
        return null;
    }

    @Override
    public List<Chamado> getEncerradosUsersDiaCount() {
        return null;
    }

    @Override
    public List<Chamado> getEncerradosAtrasadosMesCount() {
        return null;
    }

    @Override
    public List<Chamado> getEncerradosAtrasadosDiaCount() {
        return null;
    }

    @Override
    public List<Chamado> getChamadosCountHoje() {
        return null;
    }

    @Override
    public List<Chamado> getChamadosCountMes() {
        return null;
    }

    @Override
    public List<Chamado> getHistoricoById() {
        return null;
    }
}
