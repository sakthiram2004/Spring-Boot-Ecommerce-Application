package com.e_commerce.ecommerce_app.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class ImageDto {
    private Long id;
    private String fileName;
    private String downloadUrl;

}