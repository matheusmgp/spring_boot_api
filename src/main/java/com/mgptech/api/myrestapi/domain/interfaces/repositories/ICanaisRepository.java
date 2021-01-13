package com.mgptech.api.myrestapi.domain.interfaces.repositories;

import com.mgptech.api.myrestapi.domain.entities.Canais;
import com.mgptech.api.myrestapi.domain.entities.Categoria;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ICanaisRepository extends IBaseRepository<Canais> {

   /* @Query(
            value = "SELECT * from canais where nome like'%:nome%' ",
            nativeQuery = true)
    Canais teste(  @Param("nome") String nome);*/

   /* @Query(
            value = "SELECT * FROM canais ",
            nativeQuery = true)*/
    List<Canais> findByNomeContaining(String nome);







}
