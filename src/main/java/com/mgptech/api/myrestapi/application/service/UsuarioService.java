/**
 * 
 */
package com.mgptech.api.myrestapi.application.service;

import com.mgptech.api.myrestapi.domain.entities.Filial;
import com.mgptech.api.myrestapi.services.controllers.exceptions.EntityNotCreatedException;
import com.mgptech.api.myrestapi.services.controllers.exceptions.EntityNotFoundException;
import com.mgptech.api.myrestapi.services.interfaces.IUsuarioService;

import java.util.List;

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

    public Usuario create(Usuario usuario) {
        try {
            Usuario savedUsuario =  _usuarioRepository.save(usuario);
        }catch (RuntimeException ex) {
            new EntityNotCreatedException("Could not create entity");
        }
        return usuario;
    }

    public Long delete(Long id) {
    	_usuarioRepository.deleteById(id);
        return id;
    }

    public Usuario update(Long id,Usuario newUsuario) throws Exception {
    	Usuario usuario = _usuarioRepository.getOne(id);
        if (usuario == null) {
            throw new Exception();
        }
        if (usuario.getId() != id) {
            throw new IllegalArgumentException();
        }

        newUsuario.setId(id);
        Usuario UsuarioDB = _usuarioRepository.save(newUsuario);
        return UsuarioDB;
    }
}


