package com.example.demo.integration.controller;

import com.example.demo.integration.payload.ImageUploadResponse;
import com.example.demo.integration.service.ViewImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("appV")
public class ViewImageController {

@Autowired
    private ViewImageService viewImageService;

@RequestMapping(value="/view/{imageId}",method = RequestMethod.GET)
    public ResponseEntity<ImageUploadResponse>  viewImage(@PathVariable String imageId){
    return viewImageService.viewImage(imageId);
}
}
