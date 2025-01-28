package com.abinash.eCommerce.services;

import org.springframework.stereotype.Service;

@Service
public class FakeStoreCategoryServiceImpl implements CategoryService{

    @Override
    public String getProductsInCategory(int productId) {
        return "";
    }

    @Override
    public String getAllCategories() {
        return "";
    }
}
