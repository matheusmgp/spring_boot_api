package com.mgptech.api.myrestapi.domain.interfaces.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mgptech.api.myrestapi.domain.entities.Chamado;

/**
 * IChamadoRepository
 */
public interface IChamadoRepository extends JpaRepository<Chamado, Long>{

    
}