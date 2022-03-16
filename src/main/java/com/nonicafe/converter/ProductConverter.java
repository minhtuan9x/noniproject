package com.nonicafe.converter;

import com.nonicafe.constant.UploadConstant;
import com.nonicafe.dto.CommentProductDTO;
import com.nonicafe.dto.ContactDTO;
import com.nonicafe.dto.ProductDTO;
import com.nonicafe.dto.response.ProductResponse;
import com.nonicafe.entity.ProductEntity;
import com.nonicafe.repository.ProductRepository;
import com.nonicafe.service.GoogleDriverService;
import com.nonicafe.utils.ValidateInputUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class ProductConverter {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private CommentProductConverter commentProductConverter;
    @Autowired
    private ContactConverter contactConverver;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private DecimalFormat decimalFormat;
    @Autowired
    private GoogleDriverService googleDriverService;

    public ProductEntity toProductEntity(ProductDTO productDTO) throws IOException {
        ProductEntity productEntity = modelMapper.map(productDTO, ProductEntity.class);
        ProductEntity productEntityFound = new ProductEntity();
        if (productDTO.getId() != null) {
            productEntityFound = productRepository.findOne(productDTO.getId());
            if (ValidateInputUtil.isFileValid(productDTO.getFileImgTitle())) {
                googleDriverService.delete(Arrays.asList(productEntityFound.getImgTitle().replace(UploadConstant.URL_SHOW, "")));
            }
            if (ValidateInputUtil.isFileValid(productDTO.getFileImgExpands())) {
                if (Objects.nonNull(productEntityFound.getImgLink()))
                    googleDriverService.delete(Arrays.stream(productEntityFound.getImgLink().trim().split(",")).map(item -> item.replace(UploadConstant.URL_SHOW, "")).collect(Collectors.toList()));
            }
        }
        if (ValidateInputUtil.isFileValid(productDTO.getFileImgTitle())) {
            productEntity.setImgTitle(UploadConstant.URL_SHOW + googleDriverService.upLoadImg(productDTO.getFileImgTitle()));
        } else {
            productEntity.setImgTitle(productEntityFound.getImgTitle());
        }
        if (ValidateInputUtil.isFileValid(productDTO.getFileImgExpands())) {
            List<String> ids = new ArrayList<>();
            for (MultipartFile item : productDTO.getFileImgExpands()) {
                if (ValidateInputUtil.isFileValid(item))
                    ids.add(UploadConstant.URL_SHOW + googleDriverService.upLoadImg(item));
            }
            productEntity.setImgLink(String.join(",", ids));
        } else {
            productEntity.setImgLink(productEntityFound.getImgLink());
        }
        if (productEntity.getId() == null)
            productEntity.setTotalView(0);
        else {
            productEntity.setTotalView(productRepository.findOne(productEntity.getId()).getTotalView());
        }
        return productEntity;
    }

    public ProductResponse toProductRespone(ProductEntity productEntity) {
        ProductResponse productResponse = modelMapper.map(productEntity, ProductResponse.class);
        productResponse.setTotalNewComment((int) productEntity.getCommentProductEntities()
                .stream().filter(item -> !ValidateInputUtil.isValid(item.getReply())).count());
        if (productEntity.getPrice() != null) {
            productResponse.setPriceStr(decimalFormat.format(productEntity.getPrice()));
        }
        return productResponse;
    }

    public ProductDTO toProductDTO(ProductEntity productEntity) {
        ProductDTO productDTO = modelMapper.map(productEntity, ProductDTO.class);
        List<CommentProductDTO> commentProductDTOList = new ArrayList<>();
        List<ContactDTO> contactDTOS = new ArrayList<>();
        productEntity.getCommentProductEntities().sort((o1, o2) -> (o2.getCreatedDate().toString().compareTo(o1.getCreatedDate().toString())));
        productEntity.getCommentProductEntities().forEach(item -> {
            CommentProductDTO commentProductDTO = commentProductConverter.toCommentProductDTO(item);
            commentProductDTOList.add(commentProductDTO);
        });
        List<CommentProductDTO> commentProductDTOListFinal = commentProductDTOList.size() > 30 ? commentProductDTOList.subList(0, 29) : commentProductDTOList;
        if (productEntity.getPrice() != null) {
            productDTO.setPriceStr(decimalFormat.format(productEntity.getPrice()));
        }
        if (Objects.nonNull(productEntity.getImgLink()))
            productDTO.setImgLink(Arrays.asList(productEntity.getImgLink().trim().split(",")));
        productDTO.setCommentProductDTOS(commentProductDTOListFinal);
        productDTO.setContactDTOS(contactDTOS);
        return productDTO;
    }
}
