package com.nonicafe.converter;

import com.nonicafe.dto.ReSearchDTO;
import com.nonicafe.entity.ReSearchEntity;
import com.nonicafe.utils.DateUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ReSearchConverter {
    @Autowired
    private ModelMapper modelMapper;
    public ReSearchDTO toReSearchDTO(ReSearchEntity reSearchEntity){
        ReSearchDTO reSearchDTO = modelMapper.map(reSearchEntity,ReSearchDTO.class);
        reSearchDTO.setCreateDateStr(DateUtils.toDateStr(reSearchEntity.getCreatedDate()));
        return reSearchDTO;
    }
    public ReSearchEntity toReSearchEntity(ReSearchDTO reSearchDTO){
        return modelMapper.map(reSearchDTO,ReSearchEntity.class);
    }
}
