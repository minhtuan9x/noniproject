package com.nonicafe.service;

import com.nonicafe.dto.ReSearchDTO;

import java.util.List;

public interface ReSearchService {
    void delete(Long id);
    void save(ReSearchDTO reSearchDTO);
    List<ReSearchDTO> findAll();
    ReSearchDTO findOne(Long id);
}
