package com.abinash.eCommerce.controllers;

import com.abinash.eCommerce.services.CategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }


    @GetMapping("/products/categories/{productId}")
    public String getProductsInCategory(@PathVariable int productId) {
        return "Here is the list of Products in the category" + productId;
    }

    @GetMapping("/products/categories")
    public String getAllCategories() {
        return "Category List";
    }
}
