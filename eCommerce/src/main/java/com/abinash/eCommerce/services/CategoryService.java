package com.abinash.eCommerce.services;

import com.abinash.eCommerce.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CategoryService {
    List<Product> getProductsInCategory(String category);

    List<String> getAllCategories();
}
