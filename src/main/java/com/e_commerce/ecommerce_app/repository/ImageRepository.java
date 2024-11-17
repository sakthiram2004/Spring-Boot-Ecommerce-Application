package com.e_commerce.ecommerce_app.repository;

import com.e_commerce.ecommerce_app.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ImageRepository extends JpaRepository<Image,Long> {
    List<Image> findByProductId(Long id);
}
