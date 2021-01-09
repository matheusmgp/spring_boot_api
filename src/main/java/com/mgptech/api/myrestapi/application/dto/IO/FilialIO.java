package com.mgptech.api.myrestapi.application.dto.IO;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;
import org.springframework.stereotype.Component;

import com.mgptech.api.myrestapi.application.dto.FilialDto;
import com.mgptech.api.myrestapi.domain.entities.Filial;

@Component("filialIO")
public class FilialIO {


	 private ModelMapper modelMapper;

	    final Converter<FilialDto, Filial> userConverter = new Converter<FilialDto, Filial>() {

	        @Override
	        public Filial convert(MappingContext<FilialDto, Filial> context) {
	        	FilialDto filialDto = context.getSource();
	            // @formatter:off
	        	Filial filial = new Filial();
	        	filial.setCnpj(filialDto.getCnpj());
	        	filial.setFantasia(filialDto.getFantasia());
	        	filial.setRazao( filialDto.getRazao());
	        
	            // @formatter:on
	            return filial;
	        }

			
	    };
	    public FilialIO() {
			 modelMapper = new ModelMapper();
		      modelMapper.addConverter(userConverter);
		}
	 
	    public Filial mapTo(FilialDto filialDto) {
	        return this.modelMapper.map(filialDto, Filial.class);
	    }

}
