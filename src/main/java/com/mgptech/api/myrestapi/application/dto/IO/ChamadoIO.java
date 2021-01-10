package com.mgptech.api.myrestapi.application.dto.IO;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;
import org.springframework.stereotype.Component;

import com.mgptech.api.myrestapi.application.dto.ChamadoDto;
import com.mgptech.api.myrestapi.domain.entities.Chamado;


@Component("chamadoIO")
public class ChamadoIO {

	
	 private ModelMapper modelMapper;

	    final Converter<ChamadoDto, Chamado> userConverter = new Converter<ChamadoDto, Chamado>() {

	        @Override
	        public Chamado convert(MappingContext<ChamadoDto, Chamado> context) {
	        	ChamadoDto chamadoDto = context.getSource();
	            // @formatter:off
	            Chamado chamado = new Chamado();
	            chamado.setDataAbertura(chamadoDto.getDataAbertura());
	            chamado.setDataFechamento(chamadoDto.getDataFechamento());
	            chamado.setProtocolo(chamadoDto.getProtocolo());
	            chamado.setUsuario( chamadoDto.getUsuario());
	           /* if(chamadoDto.getId() != null){
					chamado.setId(chamadoDto.getId());
				}*/

	        
	            // @formatter:on
	            return chamado;
	        }

			
	    };
	    public ChamadoIO() {
			 modelMapper = new ModelMapper();
		      modelMapper.addConverter(userConverter);
		}
	 
	    public Chamado mapTo(ChamadoDto chamadoDto) {
	        return this.modelMapper.map(chamadoDto, Chamado.class);
	    }

}
