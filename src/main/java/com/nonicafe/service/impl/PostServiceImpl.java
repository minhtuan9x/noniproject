package com.nonicafe.service.impl;

import com.nonicafe.converter.PostConverter;
import com.nonicafe.dto.AbstractDTO;
import com.nonicafe.dto.PostDTO;
import com.nonicafe.entity.PostEntity;
import com.nonicafe.repository.PostRepository;
import com.nonicafe.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private PostConverter postConverter;
    @Autowired
    private PostRepository postRepository;

    @Override
    public AbstractDTO<PostDTO> findAll(Integer page, Integer limit) {
        if (Objects.isNull(page))
            page = 1;
        AbstractDTO<PostDTO> postDTOS = new AbstractDTO<>();
        Page<PostEntity> postEntityPage = postRepository.findAll(new PageRequest(page - 1, limit));
        postDTOS.setPage(page);
        postDTOS.setTotalPage(postEntityPage.getTotalPages());
        postDTOS.setListResult(postEntityPage.getContent().stream().map(item -> postConverter.toPostDTO(item)).collect(Collectors.toList()));
        return postDTOS;
    }

    @Override
    public AbstractDTO<PostDTO> findAll(PostDTO postDTO) {
        AbstractDTO<PostDTO> abstractDTO = new AbstractDTO<>();
        abstractDTO.setListResult(postRepository.findAll(postDTO).stream()
                .map(item->postConverter.toPostDTO(item)).collect(Collectors.toList()));
        return abstractDTO;
    }

    @Override
    public PostDTO findOne(Long id) {
        if (id == null)
            return new PostDTO();
        PostEntity postEntity = postRepository.findOne(id);
        postEntity.setTotalView(postEntity.getTotalView() + 1);
        postRepository.save(postEntity);
        return id != null ? postConverter.toPostDTO(Optional.ofNullable(postRepository.findOne(id)).orElse(new PostEntity())) : new PostDTO();
    }

    @Override
    @Transactional
    public PostDTO save(PostDTO postDTO) throws IOException {
        PostEntity postEntity = postConverter.toPostEntity(postDTO);
        return postConverter.toPostDTO(postRepository.save(postEntity));
    }

    @Override
    @Transactional
    public List<Long> delete(List<Long> ids) {
        postRepository.deleteByIdIn(ids);
        return ids;
    }

    @Override
    public List<PostDTO> findTop4ByOrderByCreatedDateDesc() {
        List<PostDTO> postDTOS = new ArrayList<>();
        postRepository.findTop4ByOrderByCreatedDateDesc().forEach(item -> {
            postDTOS.add(postConverter.toPostDTO(item));
        });
        return postDTOS;
    }
}
