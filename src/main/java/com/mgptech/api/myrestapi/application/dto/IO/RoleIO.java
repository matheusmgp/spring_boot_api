package com.mgptech.api.myrestapi.application.dto.IO;

import com.mgptech.api.myrestapi.application.dto.request.CanaisDtoRequest;
import com.mgptech.api.myrestapi.application.dto.request.RoleDtoRequest;
import com.mgptech.api.myrestapi.domain.entities.Canais;
import com.mgptech.api.myrestapi.domain.entities.Role;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;
import org.springframework.stereotype.Component;

@Component("roleIO")
public class RoleIO {

    private ModelMapper modelMapper;

    final Converter<RoleDtoRequest, Role> userConverter = new Converter<RoleDtoRequest, Role>() {

        @Override
        public Role convert(MappingContext<RoleDtoRequest, Role> context) {
            RoleDtoRequest roleDtoRequest = context.getSource();
            // @formatter:off
            Role role = new Role();
            role.setNome(roleDtoRequest.getNome());
            role.setStatus(roleDtoRequest.getStatus());
            if(roleDtoRequest.getId() != null){
                role.setId(roleDtoRequest.getId());
                role.setUpdatedAt(java.util.Calendar.getInstance().getTime());

            }else{
                role.setCreatedAt(java.util.Calendar.getInstance().getTime());

            }
            return role;
        }


    };
    public RoleIO() {
        modelMapper = new ModelMapper();
        modelMapper.addConverter(userConverter);
    }

    public Role mapTo(RoleDtoRequest roleDtoRequest) {
        return this.modelMapper.map(roleDtoRequest, Role.class);
    }

}
