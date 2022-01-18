package com.nonicafe.converter;

import com.nonicafe.dto.IntroduceDTO;
import com.nonicafe.entity.IntroduceEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class IntroduceConverter {
    @Autowired
    private ModelMapper modelMapper;

    public IntroduceDTO toIntroduceDTO(IntroduceEntity introduceEntity){
        return modelMapper.map(introduceEntity,IntroduceDTO.class);
    }

    public IntroduceEntity toIntroduceEntity(IntroduceDTO introduceDTO){
        return modelMapper.map(introduceDTO,IntroduceEntity.class);
    }
}
