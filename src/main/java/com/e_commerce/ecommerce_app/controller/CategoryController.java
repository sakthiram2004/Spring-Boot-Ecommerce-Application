package com.e_commerce.ecommerce_app.controller;

import com.e_commerce.ecommerce_app.model.Category;
import com.e_commerce.ecommerce_app.response.ApiResponse;
import com.e_commerce.ecommerce_app.service.category.ICategoryService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("${api.prefix}/categories")
public class CategoryController {
    private final ICategoryService categoryService;


            @GetMapping("/all")
    public ResponseEntity<ApiResponse> getAllCategories(){
        try {
            List<Category> categories = categoryService.getAllCategories();
            return ResponseEntity.ok(new ApiResponse("Success",categories));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse("Error",HttpStatus.INTERNAL_SERVER_ERROR));
        }
    }

//    @PostMapping("/add")
//    public ResponseEntity<ApiResponse> addCategory(@RequestBody Category category)
//    {
//        try {
//            Category category1= categoryService.addCategory(category);
//            return ResponseEntity.ok(new ApiResponse("Successfully category is added ",category1));
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.CONFLICT).body(new ApiResponse("Error",null));
//
//        }
//    }



    @GetMapping("/category/{id}/category")
    public ResponseEntity<ApiResponse> getCategoryById(@PathVariable Long id){
        try {
            Category category = categoryService.getCategoryById(id);
            return ResponseEntity.ok(new ApiResponse("success",category));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(new ApiResponse("Error",null));

        }
    }
    @GetMapping("/{name}/category")
    public ResponseEntity<ApiResponse> getCategoryByName(@PathVariable String name){
        try {
            Category category = categoryService.getCategoryByName(name);
            return ResponseEntity.ok(new ApiResponse("success",category));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(new ApiResponse("Error",null));

        }
    }

//    @PutMapping("/category/{id}/update")
//    public ResponseEntity<ApiResponse> updateCategory(@PathVariable Long id,@RequestBody Category category){
//        try {
//            Category category1 = categoryService.updateCategory(category, id);
//            return ResponseEntity.ok(new ApiResponse("Update success",category1));
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("Error",null));
//
//        }
//    }
//
//    @DeleteMapping("/category/{id}/delete")
//    public ResponseEntity<ApiResponse> deleteCategory(@PathVariable Long id){
//        try {
//            categoryService.deleteCategoryById(id);
//            return ResponseEntity.ok(new ApiResponse("successfully deleted",null));
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("Error",null));
//
//        }
//    }
}
