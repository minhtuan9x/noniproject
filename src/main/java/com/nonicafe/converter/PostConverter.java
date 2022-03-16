package com.nonicafe.converter;

import com.nonicafe.constant.UploadConstant;
import com.nonicafe.dto.CommentPostDTO;
import com.nonicafe.dto.PostDTO;
import com.nonicafe.entity.PostEntity;
import com.nonicafe.repository.PostRepository;
import com.nonicafe.service.GoogleDriverService;
import com.nonicafe.utils.DateUtils;
import com.nonicafe.utils.ValidateInputUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Component
public class PostConverter {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private CommentPostConverter postConverter;
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private GoogleDriverService googleDriverService;

    public PostEntity toPostEntity(PostDTO postDTO) throws IOException {
        PostEntity postEntity = modelMapper.map(postDTO, PostEntity.class);
        if (postEntity.getId() == null) {
            postEntity.setTotalView(0);
            postEntity.setImgTitle(ValidateInputUtil.isFileValid(postDTO.getFile())
                    ? UploadConstant.URL_SHOW + googleDriverService.upLoadImg(postDTO.getFile()) : null);
        } else {
            postEntity.setTotalView(postRepository.findOne(postEntity.getId()).getTotalView());
            PostEntity postEntityFound = postRepository.findOne(postDTO.getId());
            if (ValidateInputUtil.isFileValid(postDTO.getFile()))
                googleDriverService.delete(Arrays.asList(Objects.isNull(postEntityFound.getImgTitle()) ? "" : postEntityFound.getImgTitle().replace(UploadConstant.URL_SHOW, "")));
            postEntity.setImgTitle(ValidateInputUtil.isFileValid(postDTO.getFile())
                    ? UploadConstant.URL_SHOW + googleDriverService.upLoadImg(postDTO.getFile()) : postEntityFound.getImgTitle());
        }
        return postEntity;
    }

    public PostDTO toPostDTO(PostEntity postEntity) {
        PostDTO postDTO = modelMapper.map(postEntity, PostDTO.class);
        postDTO.setCreateDateStr(DateUtils.toDateStr(postDTO.getCreatedDate()));
        postDTO.setTotalNewComment((int) postEntity.getCommentPostEntities()
                .stream().filter(item->!ValidateInputUtil.isValid(item.getReply())).count());
        List<CommentPostDTO> commentPostDTOS = new ArrayList<>();
        postEntity.getCommentPostEntities().forEach(item -> {
            commentPostDTOS.add(postConverter.toCommentPostDTO(item));
        });
        commentPostDTOS.sort((i1, i2) -> i2.getCreatedDate().compareTo(i1.getCreatedDate()));
        postDTO.setCommentPostDTOS(commentPostDTOS);
        return postDTO;
    }
}
