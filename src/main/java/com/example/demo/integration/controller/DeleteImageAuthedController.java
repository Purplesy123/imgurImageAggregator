package com.example.demo.integration.controller;

import com.example.demo.integration.payload.ImageUploadResponse;
import com.example.demo.integration.service.DeleteImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/appDA")
public class DeleteImageAuthedController {

    @Autowired
    DeleteImageService deleteImageService;

    @RequestMapping(value="/deleteAuthed/{imageId}",method = RequestMethod.DELETE)
    public ResponseEntity<ImageUploadResponse> deleteImageAuthed(@PathVariable String imageId) {
        return deleteImageService.deleteImageAuthed(imageId);
    }

    }
