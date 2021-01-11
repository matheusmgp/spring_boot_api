package com.mgptech.api.myrestapi.application.dto.IO;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;
import org.springframework.stereotype.Component;

import com.mgptech.api.myrestapi.application.dto.request.UsuarioDtoRequest;
import com.mgptech.api.myrestapi.domain.entities.Usuario;

@Component("usuarioIO")
public class UsuarioIO {

	 private ModelMapper modelMapper;

	    final Converter<UsuarioDtoRequest, Usuario> userConverter = new Converter<UsuarioDtoRequest, Usuario>() {

	        @Override
	        public Usuario convert(MappingContext<UsuarioDtoRequest, Usuario> context) {
	        	UsuarioDtoRequest usuarioDtoRequest = context.getSource();
	            // @formatter:off
	        	Usuario usuario = new Usuario();
	        	usuario.setAcesso(usuarioDtoRequest.getAcesso());
	        	usuario.setFirstName(usuarioDtoRequest.getFirstName());
	        	usuario.setLastName( usuarioDtoRequest.getLastName());

				if(usuarioDtoRequest.getId() != null){
					usuario.setId(usuarioDtoRequest.getId());
				}
	        
	            // @formatter:on
	            return usuario;
	        }

			
	    };
	    public UsuarioIO() {
			 modelMapper = new ModelMapper();
		      modelMapper.addConverter(userConverter);
		}
	 
	    public Usuario mapTo(UsuarioDtoRequest usuarioDtoRequest) {
	        return this.modelMapper.map(usuarioDtoRequest, Usuario.class);
	    }

}
