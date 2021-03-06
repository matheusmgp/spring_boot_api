package com.mgptech.api.myrestapi.domain.interfaces.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mgptech.api.myrestapi.domain.entities.Chamado;

import java.util.List;

/**
 * IChamadoRepository
 */
@Repository
public interface IChamadoRepository extends IBaseRepository<Chamado> {


}