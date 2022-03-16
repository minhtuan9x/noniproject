package com.nonicafe.service.impl;

import com.nonicafe.converter.ReSearchConverter;
import com.nonicafe.dto.ReSearchDTO;
import com.nonicafe.entity.ReSearchEntity;
import com.nonicafe.repository.ReSearchRepository;
import com.nonicafe.service.ReSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ReSearchServiceImpl implements ReSearchService {
    @Autowired
    private ReSearchRepository reSearchRepository;
    @Autowired
    private ReSearchConverter reSearchConverter;

    @Override
    @Transactional
    public void delete(Long id) {
        reSearchRepository.delete(id);
    }

    @Override
    @Transactional
    public void save(ReSearchDTO reSearchDTO) {
        reSearchRepository.save(reSearchConverter.toReSearchEntity(reSearchDTO));
    }

    @Override
    public List<ReSearchDTO> findAll() {
        return reSearchRepository.findAll().stream().map(item->reSearchConverter.toReSearchDTO(item)).collect(Collectors.toList());
    }

    @Override
    public ReSearchDTO findOne(Long id) {
        return reSearchConverter.toReSearchDTO(Optional.ofNullable(reSearchRepository.findOne(id)).orElse(new ReSearchEntity()));
    }
}
