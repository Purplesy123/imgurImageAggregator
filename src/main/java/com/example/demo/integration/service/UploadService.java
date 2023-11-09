package com.example.demo.integration.service;

import com.example.demo.exception.ImgurCustomException;
import com.example.demo.integration.controller.UploadImageController;
import com.example.demo.integration.payload.ImageUploadResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
@Service
public class UploadService {
    private static final Logger logger = LoggerFactory.getLogger(UploadImageController.class);
    @Value("${imgur.upload.url}")
    private String IMGUR_API_URL;
    @Value("${imgur.client.id}")
    private String IMGUR_CLIENT_ID;

    public ResponseEntity<ImageUploadResponse> uploadImage( MultipartFile file) throws ImgurCustomException {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);
        headers.set("Authorization", "Client-ID " + IMGUR_CLIENT_ID);
        HttpEntity<Object> requestEntity = new HttpEntity<>(file, headers);

        RestTemplate restTemplate = new RestTemplate();
        ImageUploadResponse uploadResponse=new ImageUploadResponse();

        ResponseEntity<ImageUploadResponse> response;
        try {

            response = restTemplate.exchange(
                    IMGUR_API_URL,
                    HttpMethod.POST,
                    requestEntity,
                    ImageUploadResponse.class
            );
            if (response.getStatusCode() == HttpStatus.OK) {
                uploadResponse=response.getBody();
                logger.info("Image uploaded to Imgur. Response: " + response.getBody());
                return ResponseEntity.ok(uploadResponse);
            }

        } catch (Exception e) {
            logger.info("Failed to upload image: "+e.getMessage());
            throw new ImgurCustomException("Failed to upload image: "+e.getMessage());

        }

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(uploadResponse);
    }
}
