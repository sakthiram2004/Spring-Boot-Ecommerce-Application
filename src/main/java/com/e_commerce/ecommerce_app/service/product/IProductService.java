package com.e_commerce.ecommerce_app.service.product;

import com.e_commerce.ecommerce_app.dto.ProductDto;
import com.e_commerce.ecommerce_app.model.Product;
import com.e_commerce.ecommerce_app.request.AddProductRequest;
import com.e_commerce.ecommerce_app.request.ProductUpdateRequest;

import java.util.List;

public interface IProductService {
    Product addProduct(AddProductRequest product);
    Product getProductById(Long id);
    void deleteProductById(Long id);
    Product updateProduct(ProductUpdateRequest product, Long productId);
    List<Product> getAllProducts();
    List<Product> getProductsByCategory(String category);
    List<Product> getProductsByBrand(String brand);
    List<Product> getProductsByCategoryAndBrand(String category, String brand);
    List<Product> getProductsByName(String name);
    List<Product> getProductsByBrandAndName(String category, String name);
    Long countProductsByBrandAndName(String brand, String name);

    List<ProductDto> getConvertedProducts(List<Product> products);

    ProductDto convertToDto(Product product);

//    List<ProductDto> getConvertedProducts(List<Product> products);
//
//    ProductDto convertToDto(Product product);
}
