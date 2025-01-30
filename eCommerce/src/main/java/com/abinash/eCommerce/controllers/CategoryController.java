package com.abinash.eCommerce.controllers;

import com.abinash.eCommerce.models.Product;
import com.abinash.eCommerce.services.CategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }


    @GetMapping("/products/categories/{categories}")
    public List<Product> getProductsInCategory(@PathVariable String category) {
        return categoryService.getProductsInCategory(category);
    }

    @GetMapping("/products/categories")
    public List<String> getAllCategories() {
        return categoryService.getAllCategories();
    }
}
