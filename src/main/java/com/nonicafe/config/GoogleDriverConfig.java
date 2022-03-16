package com.nonicafe.config;

import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.drive.Drive;
import com.nonicafe.constant.UploadConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collection;

@Configuration
public class GoogleDriverConfig {
    @Autowired
    private GoogleCredential googleCredential;

    @Bean
    public Drive getService() throws GeneralSecurityException, IOException {
        final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
        return new Drive.Builder(HTTP_TRANSPORT,
                JacksonFactory.getDefaultInstance(), googleCredential)
                .build();
    }

    @Bean
    public GoogleCredential googleCredential() throws GeneralSecurityException, IOException {
        Collection<String> elenco = new ArrayList<String>();
        elenco.add("https://www.googleapis.com/auth/drive");
        HttpTransport httpTransport = new NetHttpTransport();
        JacksonFactory jsonFactory = new JacksonFactory();
        Path CURRENT_FOLDER = Paths.get(System.getProperty("user.dir"));
        return new GoogleCredential.Builder()
                .setTransport(httpTransport)
                .setJsonFactory(jsonFactory)
                .setServiceAccountId("google-driver-api@sodium-binder-336115.iam.gserviceaccount.com")
                .setServiceAccountScopes(elenco)
                .setServiceAccountPrivateKeyFromP12File(new File(UploadConstant.URL_FILE_SERVER))
                .build();
    }
}
