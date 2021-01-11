package com.mgptech.api.myrestapi.services.interfaces;

import com.mgptech.api.myrestapi.application.dto.IdentityDto;
import com.mgptech.api.myrestapi.domain.entities.BaseEntity;
import com.mgptech.api.myrestapi.domain.entities.Chamado;

import java.util.List;

public interface IChamadoService<Entity extends BaseEntity, TDto extends IdentityDto>  extends IServiceBase<Chamado>{

    List<Entity> getSetoresMesCount();
    List<Entity> getSetoresDiaCount();
    List<Entity> getEncerradosMesCount();
    List<Entity> getSEncerradosDiaCount();
    List<Entity> getEncerradosUsersMesCount();
    List<Entity> getEncerradosUsersDiaCount ();
    List<Entity> getEncerradosAtrasadosMesCount();
    List<Entity> getEncerradosAtrasadosDiaCount();
    List<Entity> getChamadosCountHoje();
    List<Entity> getChamadosCountMes();
    List<Entity> getHistoricoById();
}
