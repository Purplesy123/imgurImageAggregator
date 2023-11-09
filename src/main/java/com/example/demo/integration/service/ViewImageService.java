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
public class ViewImageService {

    @Value("${imgur.view.url}")
    private String imgurViewurl;

    @Value("${imgur.client.id}")
    private String IMGUR_CLIENT_ID;

    public ResponseEntity<ImageUploadResponse> viewImage(String imageID) {
        String getImageUrl=imgurViewurl+imageID;
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Client-ID " + IMGUR_CLIENT_ID);
        HttpEntity<Object> requestEntity = new HttpEntity<>(headers);
        RestTemplate restTemplate=new RestTemplate();
        return restTemplate.exchange(getImageUrl, HttpMethod.GET, requestEntity, ImageUploadResponse.class);





    }

}
