package com.mgptech.api.myrestapi.services.interfaces;

import java.util.List;

import com.mgptech.api.myrestapi.application.dto.IdentityDto;
import com.mgptech.api.myrestapi.domain.entities.BaseEntity;

/**
 * IBaseService
 */
public interface IBaseService<T extends IdentityDto,TEntity extends BaseEntity> {

    T GetById(long id);
    List<T> GetALL();
    T Create(T dto);
    T Update(T dto);
    int Delete(long id);
}