package com.mgptech.api.myrestapi.domain.interfaces.repositories;


import com.mgptech.api.myrestapi.domain.entities.Chamado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mgptech.api.myrestapi.domain.entities.Usuario;

/**
 * IUsuarioRepository
 */
@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario,Long> {

    
}