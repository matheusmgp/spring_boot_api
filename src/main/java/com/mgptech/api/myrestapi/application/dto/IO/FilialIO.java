package com.mgptech.api.myrestapi.application.dto.IO;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;
import org.springframework.stereotype.Component;

import com.mgptech.api.myrestapi.application.dto.request.FilialDtoRequest;
import com.mgptech.api.myrestapi.domain.entities.Filial;

@Component("filialIO")
public class FilialIO {


	 private ModelMapper modelMapper;

	    final Converter<FilialDtoRequest, Filial> userConverter = new Converter<FilialDtoRequest, Filial>() {

	        @Override
	        public Filial convert(MappingContext<FilialDtoRequest, Filial> context) {
	        	FilialDtoRequest filialDtoRequire = context.getSource();
	            // @formatter:off
	        	Filial filial = new Filial();
	        	filial.setCnpj(filialDtoRequire.getCnpj());
	        	filial.setFantasia(filialDtoRequire.getFantasia());
	        	filial.setRazao( filialDtoRequire.getRazao());
				filial.setDataBloqueio( filialDtoRequire.getDataBloqueio());
				filial.setDataExpiracao( filialDtoRequire.getDataExpiracao());
				filial.setDiaVencimento( filialDtoRequire.getDiaVencimento());
				if(filialDtoRequire.getId() != null){
					filial.setId(filialDtoRequire.getId());
					filial.setStatus(filialDtoRequire.getStatus());
				}
				if(filialDtoRequire.getMac() != null){
					filial.setMac(filialDtoRequire.getMac());
				}
	        
	            // @formatter:on
	            return filial;
	        }

			
	    };
	    public FilialIO() {
			 modelMapper = new ModelMapper();
		      modelMapper.addConverter(userConverter);
		}
	 
	    public Filial mapTo(FilialDtoRequest filialDtoRequire) {
	        return this.modelMapper.map(filialDtoRequire, Filial.class);
	    }

}
