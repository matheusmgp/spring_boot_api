package com.mgptech.api.myrestapi.application.dto.IO;

import com.mgptech.api.myrestapi.application.dto.request.SubCategoriaDtoRequest;
import com.mgptech.api.myrestapi.domain.entities.SubCategoria;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;
import org.springframework.stereotype.Component;

@Component("subCategoriaIO")
public class SubCategoriaIO {


    private ModelMapper modelMapper;

    final Converter<SubCategoriaDtoRequest, SubCategoria> userConverter = new Converter<SubCategoriaDtoRequest, SubCategoria>() {

        @Override
        public SubCategoria convert(MappingContext<SubCategoriaDtoRequest, SubCategoria> context) {
            SubCategoriaDtoRequest subCategoriaDtoRequest = context.getSource();
            // @formatter:off
            SubCategoria subCategoria = new SubCategoria();
            subCategoria.setNome(subCategoriaDtoRequest.getNome());
            subCategoria.setStatus(subCategoriaDtoRequest.getStatus());
            if(subCategoriaDtoRequest.getId() != null){
                subCategoria.setId(subCategoriaDtoRequest.getId());
            }
            return subCategoria;
        }


    };
    public SubCategoriaIO() {
        modelMapper = new ModelMapper();
        modelMapper.addConverter(userConverter);
    }

    public SubCategoria mapTo(SubCategoriaDtoRequest subCategoriaDtoRequest) {
        return this.modelMapper.map(subCategoriaDtoRequest, SubCategoria.class);
    }

}
