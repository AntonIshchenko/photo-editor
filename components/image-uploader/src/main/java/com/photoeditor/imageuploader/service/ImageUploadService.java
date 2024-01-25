package com.photoeditor.imageuploader.service;

import com.photoeditor.imageuploader.entity.ImageEntity;
import com.photoeditor.imageuploader.storage.AWSS3Service;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Objects;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class ImageUploadService {

    private final AWSS3Service awss3Service;

    public static final String CONTENT_TYPE_IMAGE = "image";

    @SneakyThrows
    public UUID uploadNewImage(@NonNull MultipartFile imageFile, String tags) {
        String contentType = imageFile.getContentType();
        if (contentType == null || !contentType.contains(CONTENT_TYPE_IMAGE)) {
            return null;
//            throw exceptionFactory.invalidFileFormatException();
        }
        UUID uuid = UUID.nameUUIDFromBytes(imageFile.getOriginalFilename().getBytes());

        ImageEntity imageEntity = new ImageEntity();
        imageEntity.setImageTags(tags);
        imageEntity.setId(uuid);
        imageEntity.setOriginalFileName(imageFile.getOriginalFilename());
        imageEntity.setImageBytes(imageFile.getBytes());

//        System.err.println(awss3Service.listBuckets());
//        awss3Service.createBucket("tempbucket");
//        System.err.println(awss3Service.listBuckets());
        return uuid;
    }
}
