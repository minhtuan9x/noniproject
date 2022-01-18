package com.nonicafe.dto.request;

import org.springframework.web.multipart.MultipartFile;

public class UploadRequest {
    private MultipartFile file;
    private String text;

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
