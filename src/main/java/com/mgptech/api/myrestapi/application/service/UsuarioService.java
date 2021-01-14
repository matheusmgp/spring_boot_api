/**
 * 
 */
package com.mgptech.api.myrestapi.application.service;

import com.mgptech.api.myrestapi.domain.entities.Filial;
import com.mgptech.api.myrestapi.domain.entities.SubCategoria;
import com.mgptech.api.myrestapi.services.controllers.exceptions.EntityNotCreatedException;
import com.mgptech.api.myrestapi.services.controllers.exceptions.EntityNotFoundException;
import com.mgptech.api.myrestapi.services.interfaces.IUsuarioService;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mgptech.api.myrestapi.domain.entities.Usuario;
import com.mgptech.api.myrestapi.domain.interfaces.repositories.IUsuarioRepository;

/**
 * @author matheus
 *
 */
@Service
public class UsuarioService implements IUsuarioService {

	private IUsuarioRepository _usuarioRepository;
    //@Autowired
    public UsuarioService(IUsuarioRepository repository) {

        _usuarioRepository = repository;
    }

    public List<Usuario> findAll() {
        return _usuarioRepository.findAll();

    }

    public Usuario findById(Long id) {
        return  _usuarioRepository.findById(id) .orElseThrow(
                () -> new EntityNotFoundException("ID not found "+ id));
    }

    public Long delete(Long id) {
    	_usuarioRepository.deleteById(id);
        return id;
    }

    public Usuario create(Usuario usuario) {
        return  _usuarioRepository.save(usuario);
    }

    public Usuario update(Long id,Usuario usuarioUpdated) {
        usuarioUpdated.setId(id);
        return _usuarioRepository.save(usuarioUpdated);

    }

    public Optional<Usuario> findByEmail(String email){
       return _usuarioRepository.findByEmail(email);
    }
    public Boolean emailExists(String email){
        var retorno = _usuarioRepository.findByEmail(email);
        if(!retorno.isEmpty()){
            return true;
        }else{
            return false;
        }
    }
}


