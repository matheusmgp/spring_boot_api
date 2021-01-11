package com.mgptech.api.myrestapi.application.service;


import com.mgptech.api.myrestapi.domain.entities.Categoria;
import com.mgptech.api.myrestapi.domain.entities.Chamado;
import com.mgptech.api.myrestapi.domain.interfaces.repositories.ICategoriaRepository;
import com.mgptech.api.myrestapi.domain.interfaces.repositories.IChamadoRepository;
import com.mgptech.api.myrestapi.services.controllers.exceptions.EntityNotCreatedException;
import com.mgptech.api.myrestapi.services.controllers.exceptions.EntityNotFoundException;
import com.mgptech.api.myrestapi.services.interfaces.ICategoriaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService implements ICategoriaService {

    private ICategoriaRepository _categoriaRepository;
    //@Autowired
    public CategoriaService(ICategoriaRepository repository) {
        _categoriaRepository = repository;
    }

    public List<Categoria> findAll() {
        return _categoriaRepository.findAll();

    }

    public Categoria findById(Long id) {
        return  _categoriaRepository.findById(id)
                .orElseThrow(
                        () -> new EntityNotFoundException("ID not found "+ id));
    }

    public Categoria create(Categoria categoria) {
        try {
            Categoria savedCategoria =  _categoriaRepository.save(categoria);
        }catch (RuntimeException ex) {
            new EntityNotCreatedException("Could not create entity");
        }
        return categoria;

    }

    public void delete(Long id) {
        _categoriaRepository.deleteById(id);
    }

    public Categoria update(Long id,Categoria newCategoria) throws Exception {
        Categoria categoria = _categoriaRepository.getOne(id);
        if (categoria == null) {
            throw new Exception();
        }
        if (categoria.getId() != id) {
            throw new IllegalArgumentException();
        }

        newCategoria.setId(id);
        Categoria categoriaDB = _categoriaRepository.save(newCategoria);
        return categoriaDB;
    }
}
