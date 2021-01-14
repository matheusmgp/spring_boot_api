package com.mgptech.api.myrestapi.application.dto.IO;


import com.mgptech.api.myrestapi.application.dto.request.ChamadoDtoRequest;
import com.mgptech.api.myrestapi.application.dto.request.FilialEnderecoDtoRequest;
import com.mgptech.api.myrestapi.domain.entities.Chamado;
import com.mgptech.api.myrestapi.domain.entities.FilialEndereco;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;
import org.springframework.stereotype.Component;

@Component("filialEnderecoIO")
public class FilialEnderecoIO {

    private ModelMapper modelMapper;

    final Converter<FilialEnderecoDtoRequest, FilialEndereco> userConverter = new Converter<FilialEnderecoDtoRequest, FilialEndereco>() {

        @Override
        public FilialEndereco convert(MappingContext<FilialEnderecoDtoRequest, FilialEndereco> context) {
            FilialEnderecoDtoRequest filialEnderecoDtoRequest = context.getSource();
            // @formatter:off
            FilialEndereco filialEndereco = new FilialEndereco();
            filialEndereco.setBairro(filialEnderecoDtoRequest.getBairro());
            filialEndereco.setCidade(filialEnderecoDtoRequest.getCidade());
            filialEndereco.setLogradouto(filialEnderecoDtoRequest.getLogradouto());
            filialEndereco.setNumero(filialEnderecoDtoRequest.getNumero());
            filialEndereco.setUf(filialEnderecoDtoRequest.getUf());
            filialEndereco.setCep(filialEnderecoDtoRequest.getCep());

            if(filialEnderecoDtoRequest.getComplemento() != null){
                filialEndereco.setComplemento(filialEnderecoDtoRequest.getComplemento());
            }
            if(filialEnderecoDtoRequest.getId() != null){
                filialEndereco.setId(filialEnderecoDtoRequest.getId());
            }
            // @formatter:on
            return filialEndereco;
        }


    };
    public FilialEnderecoIO() {
        modelMapper = new ModelMapper();
        modelMapper.addConverter(userConverter);
    }

    public FilialEndereco mapTo(FilialEnderecoDtoRequest filialEnderecoDtoRequest) {
        return this.modelMapper.map(filialEnderecoDtoRequest, FilialEndereco.class);
    }

}
