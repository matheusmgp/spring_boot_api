package com.mgptech.api.myrestapi.application.dto.IO;


import com.mgptech.api.myrestapi.application.dto.CategoriaDto;
import com.mgptech.api.myrestapi.application.dto.FilialDto;
import com.mgptech.api.myrestapi.domain.entities.Categoria;
import com.mgptech.api.myrestapi.domain.entities.Filial;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;
import org.springframework.stereotype.Component;

@Component("categoriaIO")
public class CategoriaIO {



    private ModelMapper modelMapper;

    final Converter<CategoriaDto, Categoria> userConverter = new Converter<CategoriaDto, Categoria>() {

        @Override
        public Categoria convert(MappingContext<CategoriaDto, Categoria> context) {
            CategoriaDto categoriaDto = context.getSource();
            // @formatter:off
            Categoria categoria = new Categoria();
            categoria.setNome(categoriaDto.getNome());

            return categoria;
        }


    };
    public CategoriaIO() {
        modelMapper = new ModelMapper();
        modelMapper.addConverter(userConverter);
    }

    public Categoria mapTo(CategoriaDto categoriaDto) {
        return this.modelMapper.map(categoriaDto, Categoria.class);
    }

}
