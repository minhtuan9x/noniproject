package com.nonicafe.service.impl;

import com.google.api.client.http.InputStreamContent;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.model.File;
import com.google.api.services.drive.model.FileList;
import com.nonicafe.converter.ImageConverter;
import com.nonicafe.dto.ImageDTO;
import com.nonicafe.service.GoogleDriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GoogleDriverServiceImpl implements GoogleDriverService {


    @Autowired
    private Drive drive;
    @Autowired
    private ImageConverter imageConverter;

    @Override
    public String upLoadImg(MultipartFile file) throws IOException {
        File fileMetadata = new File();//file cua google
        fileMetadata.setParents(Arrays.asList("1nOGlXAEQxdLMdALdI9FE6nnmASDqG-Ut"));
        fileMetadata.setName(file.getOriginalFilename());
        InputStreamContent mediaContent = new InputStreamContent(file.getContentType(), new ByteArrayInputStream(file.getBytes()));
        File fileUp = drive.files().create(fileMetadata, mediaContent)
                .setFields("id,webViewLink")
                .execute();
        System.out.println("File ID: " + fileUp.getId());
        System.out.println("File part: " + fileUp.getWebViewLink());
        return fileUp.getId();
    }

    @Override
    public String upLoadImg(MultipartFile file, String text) throws IOException {
        File fileMetadata = new File();//file cua google
        fileMetadata.setParents(Arrays.asList("1nOGlXAEQxdLMdALdI9FE6nnmASDqG-Ut"));
        fileMetadata.setName(text.isEmpty()?file.getOriginalFilename():text);
        InputStreamContent mediaContent = new InputStreamContent(file.getContentType(), new ByteArrayInputStream(file.getBytes()));
        File fileUp = drive.files().create(fileMetadata, mediaContent)
                .setFields("id,webViewLink")
                .execute();
        System.out.println("File ID: " + fileUp.getId());
        System.out.println("File part: " + fileUp.getWebViewLink());
        return fileUp.getId();
    }

    @Override
    public List<ImageDTO> getAll() throws IOException {
        List<ImageDTO> imageDTOS = new ArrayList<>();
        String pageToken = null;
        do{
            FileList result = drive.files().list()
                    .setQ("mimeType != 'application/vnd.google-apps.folder'")
                    .setFields("nextPageToken, files(id, name, parents, mimeType)")
                    .execute();
            imageDTOS.addAll(result.getFiles().stream().map(item->imageConverter.toImageDTO(item)).collect(Collectors.toList()));
            pageToken= result.getNextPageToken();
        }while (pageToken!=null);
        return imageDTOS;
    }

    @Override
    public List<String> delete(List<String> ids) {
            ids.forEach(item-> {
                try {
                    drive.files().delete(item).execute();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        return ids;
    }

    @Override
    public void downLoad(String id) throws IOException {
        OutputStream outputStream = new ByteArrayOutputStream();
        drive.files().get(id).executeMediaAndDownloadTo(outputStream);
    }
}
