package com.mgptech.api.myrestapi.application.dto.IO;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;
import org.springframework.stereotype.Component;

import com.mgptech.api.myrestapi.application.dto.request.ChamadoDtoRequest;
import com.mgptech.api.myrestapi.domain.entities.Chamado;


@Component("chamadoIO")
public class ChamadoIO {

	
	 private ModelMapper modelMapper;

	    final Converter<ChamadoDtoRequest, Chamado> userConverter = new Converter<ChamadoDtoRequest, Chamado>() {

	        @Override
	        public Chamado convert(MappingContext<ChamadoDtoRequest, Chamado> context) {
	        	ChamadoDtoRequest chamadoDtoRequire = context.getSource();
	            // @formatter:off
	            Chamado chamado = new Chamado();
	            chamado.setDataAbertura(chamadoDtoRequire.getDataAbertura());
	            chamado.setDataFechamento(chamadoDtoRequire.getDataFechamento());
	            chamado.setProtocolo(chamadoDtoRequire.getProtocolo());
				chamado.setStatus(chamadoDtoRequire.getStatus());
				if(chamadoDtoRequire.getId() != null){
					chamado.setId(chamadoDtoRequire.getId());
				}
	            // @formatter:on
	            return chamado;
	        }

			
	    };
	    public ChamadoIO() {
			 modelMapper = new ModelMapper();
		      modelMapper.addConverter(userConverter);
		}
	 
	    public Chamado mapTo(ChamadoDtoRequest chamadoDtoRequire) {
	        return this.modelMapper.map(chamadoDtoRequire, Chamado.class);
	    }

}
