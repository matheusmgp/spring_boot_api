package com.mgptech.api.myrestapi.services.interfaces;

import com.mgptech.api.myrestapi.application.dto.ChamadoDto;
import com.mgptech.api.myrestapi.domain.entities.Chamado;

import java.util.List;

public interface IChamadoService  extends IServiceBase<Chamado>{

    List<Chamado> getSetoresMesCount();
    List<Chamado> getSetoresDiaCount();
    List<Chamado> getEncerradosMesCount();
    List<Chamado> getSEncerradosDiaCount();
    List<Chamado> getEncerradosUsersMesCount();
    List<Chamado> getEncerradosUsersDiaCount ();
    List<Chamado> getEncerradosAtrasadosMesCount();
    List<Chamado> getEncerradosAtrasadosDiaCount();
    List<Chamado> getChamadosCountHoje();
    List<Chamado> getChamadosCountMes();
    List<Chamado> getHistoricoById();
}
