package com.mgptech.api.myrestapi.application.dto.IO;

import com.mgptech.api.myrestapi.application.dto.SubCategoriaDto;
import com.mgptech.api.myrestapi.domain.entities.SubCategoria;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;
import org.springframework.stereotype.Component;

@Component("subCategoriaIO")
public class SubCategoriaIO {


    private ModelMapper modelMapper;

    final Converter<SubCategoriaDto, SubCategoria> userConverter = new Converter<SubCategoriaDto, SubCategoria>() {

        @Override
        public SubCategoria convert(MappingContext<SubCategoriaDto, SubCategoria> context) {
            SubCategoriaDto subCategoriaDto = context.getSource();
            // @formatter:off
            SubCategoria subCategoria = new SubCategoria();
            subCategoria.setNome(subCategoriaDto.getNome());
            subCategoria.setStatus(subCategoriaDto.getStatus());
            if(subCategoriaDto.getId() != null){
                subCategoria.setId(subCategoriaDto.getId());
            }
            return subCategoria;
        }


    };
    public SubCategoriaIO() {
        modelMapper = new ModelMapper();
        modelMapper.addConverter(userConverter);
    }

    public SubCategoria mapTo(SubCategoriaDto subCategoriaDto) {
        return this.modelMapper.map(subCategoriaDto, SubCategoria.class);
    }

}
