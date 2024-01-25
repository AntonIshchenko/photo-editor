package com.photoeditor.imageuploader.entity;

import lombok.Data;

import java.util.UUID;

@Data
public class ImageEntity {
    private String imageTags;
    private UUID id;
    private String originalFileName;
    private byte[] imageBytes;
}
