package com.mgptech.api.myrestapi.services.interfaces;

import com.mgptech.api.myrestapi.domain.entities.BaseEntity;
import java.util.List;

public interface IServiceBase<Entity extends BaseEntity> {

    List<Entity> findAll();
    Entity findById(Long id);
    Entity create(Entity BaseEntity);
    Long delete(Long id);
    Entity update(Long id,Entity BaseEntity) throws Exception;

}
