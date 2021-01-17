package com.mgptech.api.myrestapi.domain.interfaces.repositories;

import com.mgptech.api.myrestapi.domain.entities.Chamado;
import com.mgptech.api.myrestapi.domain.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mgptech.api.myrestapi.domain.entities.Filial;

import java.util.Optional;

/**
 * IFilialRepository
 */
@Repository
public interface IFilialRepository extends IBaseRepository<Filial> {
    Optional<Filial> findByCnpj(String cnpj);
    
}