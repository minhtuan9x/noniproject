package com.nonicafe.service.impl;

import com.nonicafe.converter.IntroduceConverter;
import com.nonicafe.dto.IntroduceDTO;
import com.nonicafe.entity.IntroduceEntity;
import com.nonicafe.repository.IntroduceRepository;
import com.nonicafe.service.IntroduceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class IntroduceServiceImpl implements IntroduceService {
    @Autowired
    private IntroduceRepository introduceRepository;
    @Autowired
    private IntroduceConverter introduceConverter;

    @Override
    public IntroduceDTO findOne(Long id) {
        return introduceConverter.toIntroduceDTO(Optional.ofNullable(introduceRepository.findOne(id)).orElse(new IntroduceEntity()));
    }

    @Override
    @Transactional
    public void save(IntroduceDTO introduceDTO) {
        introduceRepository.save(introduceConverter.toIntroduceEntity(introduceDTO));
    }
}
