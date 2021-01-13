package com.mgptech.api.myrestapi.domain.interfaces.repositories;


import com.mgptech.api.myrestapi.domain.entities.Chamado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mgptech.api.myrestapi.domain.entities.Usuario;

import java.util.Optional;

/**
 * IUsuarioRepository
 */
@Repository
public interface IUsuarioRepository extends IBaseRepository<Usuario> {

    Optional<Usuario> findByEmail(String email);


}