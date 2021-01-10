package com.mgptech.api.myrestapi.application.dto.IO;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;
import org.springframework.stereotype.Component;

import com.mgptech.api.myrestapi.application.dto.ChamadoDto;
import com.mgptech.api.myrestapi.application.dto.UsuarioDto;
import com.mgptech.api.myrestapi.domain.entities.Chamado;
import com.mgptech.api.myrestapi.domain.entities.Usuario;

@Component("usuarioIO")
public class UsuarioIO {

	 private ModelMapper modelMapper;

	    final Converter<UsuarioDto, Usuario> userConverter = new Converter<UsuarioDto, Usuario>() {

	        @Override
	        public Usuario convert(MappingContext<UsuarioDto, Usuario> context) {
	        	UsuarioDto usuarioDto = context.getSource();
	            // @formatter:off
	        	Usuario usuario = new Usuario();
	        	usuario.setAcesso(usuarioDto.getAcesso());
	        	usuario.setFirstName(usuarioDto.getFirstName());
	        	usuario.setLastName( usuarioDto.getLastName());

				if(usuarioDto.getId() != null){
					usuario.setId(usuarioDto.getId());
				}
	        
	            // @formatter:on
	            return usuario;
	        }

			
	    };
	    public UsuarioIO() {
			 modelMapper = new ModelMapper();
		      modelMapper.addConverter(userConverter);
		}
	 
	    public Usuario mapTo(UsuarioDto usuarioDto) {
	        return this.modelMapper.map(usuarioDto, Usuario.class);
	    }

}
