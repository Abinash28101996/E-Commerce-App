package com.abinash.eCommerce.services;

import org.springframework.stereotype.Service;


public interface CategoryService {
    String getProductsInCategory(int productId);

    String getAllCategories();
}
