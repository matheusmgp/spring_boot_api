package com.mgptech.api.myrestapi.domain.interfaces.repositories;


import com.mgptech.api.myrestapi.domain.entities.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBaseRepository <TEntity extends BaseEntity> extends JpaRepository<TEntity, Long> {
//public interface IBaseRepository {

}
