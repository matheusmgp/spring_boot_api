package com.mgptech.api.myrestapi.application.dto.IO;

import com.mgptech.api.myrestapi.application.dto.request.SetorDtoRequest;
import com.mgptech.api.myrestapi.domain.entities.Setor;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;
import org.springframework.stereotype.Component;

@Component("setorIO")
public class SetorIO {

    private ModelMapper modelMapper;

    final Converter<SetorDtoRequest, Setor> userConverter = new Converter<SetorDtoRequest, Setor>() {

        @Override
        public Setor convert(MappingContext<SetorDtoRequest, Setor> context) {
            SetorDtoRequest setorDtoRequest = context.getSource();
            // @formatter:off
            Setor setor = new Setor();
            setor.setNome(setorDtoRequest.getNome());
            setor.setStatus(setorDtoRequest.getStatus());
            if(setorDtoRequest.getId() != null){
                setor.setId(setorDtoRequest.getId());
            }
            return setor;
        }


    };
    public SetorIO() {
        modelMapper = new ModelMapper();
        modelMapper.addConverter(userConverter);
    }

    public Setor mapTo(SetorDtoRequest setorDtoRequest) {
        return this.modelMapper.map(setorDtoRequest, Setor.class);
    }

}
