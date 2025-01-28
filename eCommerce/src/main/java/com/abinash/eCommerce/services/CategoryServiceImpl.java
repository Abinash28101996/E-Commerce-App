package com.abinash.eCommerce.services;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public class CategoryServiceImpl implements CategoryService {

    @Override
    public String getProductsInCategory(int productId) {
        return "Here is the list of Products in the category" + productId;
    }

    @Override
    public String getAllCategories() {
        return "Category List";
    }
}
