package com.nonicafe.api.admin;

import com.nonicafe.dto.ImageDTO;
import com.nonicafe.dto.request.UploadRequest;
import com.nonicafe.service.GoogleDriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/upload")
public class GoogleDriverAPI {
    @Autowired
    private GoogleDriverService googleDriverService;


    @GetMapping
    public ResponseEntity<List<ImageDTO>> getAll() throws IOException {
        return ResponseEntity.ok(googleDriverService.getAll());
    }
    @PostMapping
    public String upload(@RequestBody MultipartFile file) throws IOException {
        return googleDriverService.upLoadImg(file);
    }
    @PostMapping("/option")
    public String upload(@ModelAttribute UploadRequest uploadRequest) throws IOException {
        return googleDriverService.upLoadImg(uploadRequest.getFile(),uploadRequest.getText());
    }
    @DeleteMapping
    public ResponseEntity<Void> delete(@RequestBody List<String> ids){
        googleDriverService.delete(ids);
        return ResponseEntity.noContent().build();
    }

}
