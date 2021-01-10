package com.mgptech.api.myrestapi.application.dto.IO;

import com.mgptech.api.myrestapi.application.dto.PendenciaDto;
import com.mgptech.api.myrestapi.domain.entities.Pendencia;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;
import org.springframework.stereotype.Component;

@Component("pendencioIO")
public class PendenciaIO {

    private ModelMapper modelMapper;

    final Converter<PendenciaDto, Pendencia> userConverter = new Converter<PendenciaDto, Pendencia>() {

        @Override
        public Pendencia convert(MappingContext<PendenciaDto, Pendencia> context) {
            PendenciaDto pendenciaDto = context.getSource();
            // @formatter:off
            Pendencia pendencia = new Pendencia();
            pendencia.setDataAbertura(pendenciaDto.getDataAbertura());
            pendencia.setDataFechamento(pendenciaDto.getDataFechamento());
            pendencia.setStatus(pendenciaDto.getStatus());
            pendencia.setDescricao(pendenciaDto.getDescricao());
            pendencia.setSolucao(pendenciaDto.getSolucao());

            if(pendenciaDto.getId() != null){
                pendencia.setId(pendenciaDto.getId());
            }
            return pendencia;
        }


    };
    public PendenciaIO() {
        modelMapper = new ModelMapper();
        modelMapper.addConverter(userConverter);
    }

    public Pendencia mapTo(PendenciaDto pendenciaDto) {
        return this.modelMapper.map(pendenciaDto, Pendencia.class);
    }

}

