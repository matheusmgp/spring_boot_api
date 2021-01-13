package com.mgptech.api.myrestapi.services.interfaces;


import com.mgptech.api.myrestapi.domain.entities.Canais;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ICanaisService extends IServiceBase<Canais>{



    List<Canais> findByNomeContaining(String nome);
}