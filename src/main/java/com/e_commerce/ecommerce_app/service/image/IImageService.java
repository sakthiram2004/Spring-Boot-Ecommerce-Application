package com.e_commerce.ecommerce_app.service.image;


import com.e_commerce.ecommerce_app.dto.ImageDto;
import com.e_commerce.ecommerce_app.model.Image;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface IImageService {
    Image getImageById(Long id);
    void deleteImageById(Long id);
    List<ImageDto> saveImages(Long productId, List<MultipartFile> files);
    void updateImage(MultipartFile file,  Long imageId);
}