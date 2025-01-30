package com.abinash.eCommerce.services;

import com.abinash.eCommerce.models.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public class CategoryServiceImpl implements CategoryService {

    @Override
    public List<Product> getProductsInCategory(String category) {
        return null;
    }

    @Override
    public List<String> getAllCategories() {
        return null;
    }
}
