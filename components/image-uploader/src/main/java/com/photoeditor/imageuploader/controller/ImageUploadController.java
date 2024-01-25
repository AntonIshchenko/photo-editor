package com.photoeditor.imageuploader.controller;

import com.photoeditor.imageuploader.service.ImageUploadService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "api/v1/upload")
public class ImageUploadController {

    private final ImageUploadService uploadService;

    @PostMapping(path = "", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public UUID uploadNewResource(@RequestParam(value = "file") MultipartFile file, @RequestParam(required = false) String tags) {
        if(file == null) {
            return null; //throw bad request
        }
        return uploadService.uploadNewImage(file, tags);
    }


}
