package com.mgptech.api.myrestapi.application.dto.IO;

import com.mgptech.api.myrestapi.application.dto.request.CanaisDtoRequest;
import com.mgptech.api.myrestapi.domain.entities.Canais;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;
import org.springframework.stereotype.Component;

@Component("canaisIO")
public class CanaisIO {


    private ModelMapper modelMapper;

    final Converter<CanaisDtoRequest, Canais> userConverter = new Converter<CanaisDtoRequest, Canais>() {

        @Override
        public Canais convert(MappingContext<CanaisDtoRequest, Canais> context) {
            CanaisDtoRequest canaisDtoRequire = context.getSource();
            // @formatter:off
            Canais canais = new Canais();
            canais.setNome(canaisDtoRequire.getNome());
            canais.setStatus(canaisDtoRequire.getStatus());
            if(canaisDtoRequire.getId() != null){
                canais.setId(canaisDtoRequire.getId());
            }
            return canais;
        }


    };
    public CanaisIO() {
        modelMapper = new ModelMapper();
        modelMapper.addConverter(userConverter);
    }

    public Canais mapTo(CanaisDtoRequest canaisDtoRequire) {
        return this.modelMapper.map(canaisDtoRequire, Canais.class);
    }

}

