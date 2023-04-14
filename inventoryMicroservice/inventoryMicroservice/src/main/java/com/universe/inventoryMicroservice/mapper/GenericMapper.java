package com.universe.inventoryMicroservice.mapper;

import com.universe.inventoryMicroservice.dto.BaseDTO;
import com.universe.inventoryMicroservice.model.BaseModel;

import java.util.*;

public abstract class GenericMapper <DTO extends BaseDTO,DOMAIN extends BaseModel>{

    public abstract void dtoToDomain(DOMAIN domain,DTO dto);
    public abstract DTO domainToDto(DOMAIN domain);

    public List<DTO> domainToDTOCollection(final Iterable<? extends DOMAIN> domainList) throws Exception{
        if(domainList == null) {
            return new ArrayList<>();
        }
        final List<DTO> dtoList = new ArrayList<>();

        for(final DOMAIN domain : domainList){
            dtoList.add(domainToDto(domain));
        }
        return dtoList;
    }
    protected void setVersionAndIdToDTO(DTO dto,DOMAIN domain){
        dto.setVersion(domain.getVersion());
    }

    protected void setVersionAndIdToDomain(DOMAIN domain,DTO dto){
        domain.setVersion(dto.getVersion());
    }
}
