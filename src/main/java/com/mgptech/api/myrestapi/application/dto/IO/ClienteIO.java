package com.mgptech.api.myrestapi.application.dto.IO;

import com.mgptech.api.myrestapi.application.dto.request.ClienteDtoRequest;
import com.mgptech.api.myrestapi.domain.entities.Canais;
import com.mgptech.api.myrestapi.domain.entities.Cliente;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;
import org.springframework.stereotype.Component;

@Component("clienteIO")
public class ClienteIO {

    private ModelMapper modelMapper;

    final Converter<ClienteDtoRequest, Cliente> userConverter = new Converter<ClienteDtoRequest, Cliente>() {

        @Override
        public Cliente convert(MappingContext<ClienteDtoRequest, Cliente> context) {
            ClienteDtoRequest canaisDtoRequest = context.getSource();
            // @formatter:off
            Cliente cliente = new Cliente();
            cliente.setNome(canaisDtoRequest.getNome());
            cliente.setStatus(canaisDtoRequest.getStatus());
            cliente.setCpf(canaisDtoRequest.getCpf());
            if(canaisDtoRequest.getId() != null){
                cliente.setId(canaisDtoRequest.getId());
            }
            return cliente;
        }


    };
    public ClienteIO() {
        modelMapper = new ModelMapper();
        modelMapper.addConverter(userConverter);
    }

    public Cliente mapTo(ClienteDtoRequest clienteDtoRequest) {
        return this.modelMapper.map(clienteDtoRequest, Cliente.class);
    }

}

