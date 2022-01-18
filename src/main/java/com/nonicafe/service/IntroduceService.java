package com.nonicafe.service;

import com.nonicafe.dto.IntroduceDTO;

public interface IntroduceService {
    IntroduceDTO findOne(Long id);
    void save(IntroduceDTO introduceDTO);
}
