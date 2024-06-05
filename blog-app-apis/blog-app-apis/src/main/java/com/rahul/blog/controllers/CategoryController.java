package com.rahul.blog.controllers;

import com.rahul.blog.payloads.ApiResponse;
import com.rahul.blog.payloads.CategoryDto;
import com.rahul.blog.services.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    //create
    @PostMapping("/")
    public ResponseEntity<CategoryDto> createCategory(@Valid @RequestBody CategoryDto categoryDto) {
        CategoryDto categoryDto1 = this.categoryService.createCategory(categoryDto);
        return new ResponseEntity<>(categoryDto1, HttpStatus.CREATED);
    }
    //update
    @PutMapping("/{categoryId}")
    public ResponseEntity<CategoryDto> updateCategory(@Valid @RequestBody CategoryDto categoryDto, @PathVariable Integer categoryId) {
        CategoryDto categoryDto1 = this.categoryService.updateCategory(categoryDto, categoryId);
        return new ResponseEntity<>(categoryDto1, HttpStatus.OK);
    }
    //delete
    @DeleteMapping("/{categoryId}")
    public ResponseEntity<ApiResponse> deleteCategory(@PathVariable Integer categoryId) {
        this.categoryService.deleteCategory(categoryId);
        return new ResponseEntity<>(new ApiResponse("Category is deleted Successfully !!",true), HttpStatus.OK);
    }
    //get
    @GetMapping("/{categoryId}")
    public ResponseEntity<CategoryDto> getCategory(@PathVariable Integer categoryId) {
        CategoryDto category = this.categoryService.getCategory(categoryId);
        return new ResponseEntity<>(category, HttpStatus.OK);
    }
    //get all
    @GetMapping("/")
    public ResponseEntity<List<CategoryDto>> getCategories() {
        List<CategoryDto> categories = this.categoryService.getAllCategories();
        return ResponseEntity.ok(categories);
    }
}
