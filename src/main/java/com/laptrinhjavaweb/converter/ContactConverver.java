package com.laptrinhjavaweb.converter;

import com.laptrinhjavaweb.dto.ContactDTO;
import com.laptrinhjavaweb.entity.ContactEntity;
import com.laptrinhjavaweb.enums.NeedEnums;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ContactConverver {
    @Autowired
    private ModelMapper modelMapper;

    public ContactDTO toContactDTO(ContactEntity contactEntity){
        ContactDTO contactDTO = modelMapper.map(contactEntity,ContactDTO.class);
        for(NeedEnums item: NeedEnums.values()){
//            if(item.name().equals(contactEntity.getNeed())){
//                contactDTO.setNeedKey(item.name());
//                contactDTO.setNeedValue(item.getValueNeed());
//                break;
//            }
        }
        return contactDTO;
    }
    public ContactEntity toContactEntity(ContactDTO contactDTO){
        ContactEntity contactEntity = modelMapper.map(contactDTO,ContactEntity.class);
        return contactEntity;
    }
}
