package com.e_commerce.ecommerce_app.request;

import com.e_commerce.ecommerce_app.model.Category;
import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class AddProductRequest {
    private Long id;
    private String name;
    private String discription;
    private String brand;
    private BigDecimal price;
    private int inventory;

    private Category category;
}
