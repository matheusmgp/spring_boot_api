package com.mgptech.api.myrestapi.domain.interfaces.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mgptech.api.myrestapi.domain.entities.Usuario;

/**
 * IUsuarioRepository
 */
public interface IUsuarioRepository extends JpaRepository<Usuario, Long>{

    
}