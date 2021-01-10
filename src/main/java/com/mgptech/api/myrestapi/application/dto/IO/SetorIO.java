package com.mgptech.api.myrestapi.application.dto.IO;

import com.mgptech.api.myrestapi.application.dto.CategoriaDto;
import com.mgptech.api.myrestapi.application.dto.SetorDto;
import com.mgptech.api.myrestapi.domain.entities.Categoria;
import com.mgptech.api.myrestapi.domain.entities.Setor;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;
import org.springframework.stereotype.Component;

@Component("setorIO")
public class SetorIO {

    private ModelMapper modelMapper;

    final Converter<SetorDto, Setor> userConverter = new Converter<SetorDto, Setor>() {

        @Override
        public Setor convert(MappingContext<SetorDto, Setor> context) {
            SetorDto setorDto = context.getSource();
            // @formatter:off
            Setor setor = new Setor();
            setor.setNome(setorDto.getNome());
            setor.setStatus(setorDto.getStatus());
            if(setorDto.getId() != null){
                setor.setId(setorDto.getId());
            }
            return setor;
        }


    };
    public SetorIO() {
        modelMapper = new ModelMapper();
        modelMapper.addConverter(userConverter);
    }

    public Setor mapTo(SetorDto setorDto) {
        return this.modelMapper.map(setorDto, Setor.class);
    }

}
