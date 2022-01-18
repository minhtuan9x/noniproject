package com.nonicafe.service;

import com.nonicafe.dto.ImageDTO;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface GoogleDriverService {
    String upLoadImg(MultipartFile file) throws IOException;
    String upLoadImg(MultipartFile file,String text) throws IOException;
    List<ImageDTO> getAll() throws IOException;
    List<String> delete(List<String> ids);
    void downLoad(String id) throws IOException;
}
