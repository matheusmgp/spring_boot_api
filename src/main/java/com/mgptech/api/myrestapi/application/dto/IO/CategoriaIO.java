package com.mgptech.api.myrestapi.application.dto.IO;


import com.mgptech.api.myrestapi.application.dto.request.CategoriaDtoRequest;
import com.mgptech.api.myrestapi.domain.entities.Categoria;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;
import org.springframework.stereotype.Component;

@Component("categoriaIO")
public class CategoriaIO {



    private ModelMapper modelMapper;

    final Converter<CategoriaDtoRequest, Categoria> userConverter = new Converter<CategoriaDtoRequest, Categoria>() {

        @Override
        public Categoria convert(MappingContext<CategoriaDtoRequest, Categoria> context) {
            CategoriaDtoRequest categoriaDtoRequire = context.getSource();
            // @formatter:off
            Categoria categoria = new Categoria();
            categoria.setNome(categoriaDtoRequire.getNome());
            categoria.setStatus(categoriaDtoRequire.getStatus());
            if(categoriaDtoRequire.getId() != null){
                categoria.setId(categoriaDtoRequire.getId());
            }
            return categoria;
        }


    };
    public CategoriaIO() {
        modelMapper = new ModelMapper();
        modelMapper.addConverter(userConverter);
    }

    public Categoria mapTo(CategoriaDtoRequest categoriaDtoRequire) {
        return this.modelMapper.map(categoriaDtoRequire, Categoria.class);
    }

}
