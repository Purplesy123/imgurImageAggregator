package com.example.demo.integration.controller;

import com.example.demo.exception.ImgurCustomException;
import com.example.demo.integration.payload.ImageUploadResponse;
import com.example.demo.integration.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/myappU")
public class UploadImageController {

 @Autowired
 private UploadService uploadService;

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public ResponseEntity<ImageUploadResponse> uploadImage(@RequestParam("file") MultipartFile file) throws ImgurCustomException {
    return uploadService.uploadImage(file);
    }
}
