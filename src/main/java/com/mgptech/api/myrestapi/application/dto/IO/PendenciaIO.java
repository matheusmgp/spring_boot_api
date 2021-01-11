package com.mgptech.api.myrestapi.application.dto.IO;

import com.mgptech.api.myrestapi.application.dto.request.PendenciaDtoRequest;
import com.mgptech.api.myrestapi.domain.entities.Pendencia;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;
import org.springframework.stereotype.Component;

@Component("pendencioIO")
public class PendenciaIO {

    private ModelMapper modelMapper;

    final Converter<PendenciaDtoRequest, Pendencia> userConverter = new Converter<PendenciaDtoRequest, Pendencia>() {

        @Override
        public Pendencia convert(MappingContext<PendenciaDtoRequest, Pendencia> context) {
            PendenciaDtoRequest pendenciaDtoRequest = context.getSource();
            // @formatter:off
            Pendencia pendencia = new Pendencia();
            pendencia.setDataAbertura(pendenciaDtoRequest.getDataAbertura());
            pendencia.setDataFechamento(pendenciaDtoRequest.getDataFechamento());
            pendencia.setStatus(pendenciaDtoRequest.getStatus());
            pendencia.setDescricao(pendenciaDtoRequest.getDescricao());
            pendencia.setSolucao(pendenciaDtoRequest.getSolucao());

            if(pendenciaDtoRequest.getId() != null){
                pendencia.setId(pendenciaDtoRequest.getId());
            }
            return pendencia;
        }


    };
    public PendenciaIO() {
        modelMapper = new ModelMapper();
        modelMapper.addConverter(userConverter);
    }

    public Pendencia mapTo(PendenciaDtoRequest pendenciaDtoRequest) {
        return this.modelMapper.map(pendenciaDtoRequest, Pendencia.class);
    }

}

