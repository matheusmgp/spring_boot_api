package com.mgptech.api.myrestapi.application.dto.IO;

import com.mgptech.api.myrestapi.application.dto.CanaisDto;
import com.mgptech.api.myrestapi.domain.entities.Canais;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;
import org.springframework.stereotype.Component;

@Component("canaisIO")
public class CanaisIO {


    private ModelMapper modelMapper;

    final Converter<CanaisDto, Canais> userConverter = new Converter<CanaisDto, Canais>() {

        @Override
        public Canais convert(MappingContext<CanaisDto, Canais> context) {
            CanaisDto canaisDto = context.getSource();
            // @formatter:off
            Canais canais = new Canais();
            canais.setNome(canaisDto.getNome());
            canais.setStatus(canaisDto.getStatus());
            if(canaisDto.getId() != null){
                canais.setId(canaisDto.getId());
            }
            return canais;
        }


    };
    public CanaisIO() {
        modelMapper = new ModelMapper();
        modelMapper.addConverter(userConverter);
    }

    public Canais mapTo(CanaisDto canaisDto) {
        return this.modelMapper.map(canaisDto, Canais.class);
    }

}

