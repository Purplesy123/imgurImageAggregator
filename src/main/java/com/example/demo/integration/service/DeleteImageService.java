package com.example.demo.integration.service;

import com.example.demo.integration.payload.ImageUploadResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
@Service
public class DeleteImageService {


    @Value("${imgur.delete.url}")
    private String imgurDeleteurl;

    @Value("${imgur.client.id}")
    private String IMGUR_CLIENT_ID;

    @Value("${imgur.access.token}")
    private String IMGUR_ACCESS_TOKEN;

    public ResponseEntity<ImageUploadResponse> deleteImage(String imageID) {
        String getImageUrl = imgurDeleteurl + imageID;
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Client-ID " + IMGUR_CLIENT_ID);
        HttpEntity<Object> requestEntity = new HttpEntity<>(headers);
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.exchange(getImageUrl, HttpMethod.DELETE, requestEntity, ImageUploadResponse.class);
    }

    public ResponseEntity<ImageUploadResponse> deleteImageAuthed(String imageID) {
        String getImageUrl = imgurDeleteurl + imageID;
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + IMGUR_ACCESS_TOKEN);
        HttpEntity<Object> requestEntity = new HttpEntity<>(headers);
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.exchange(getImageUrl, HttpMethod.DELETE, requestEntity, ImageUploadResponse.class);
    }

}
