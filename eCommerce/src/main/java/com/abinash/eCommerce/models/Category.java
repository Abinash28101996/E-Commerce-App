package com.abinash.eCommerce.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;


public class Category extends BaseModel{
    private String categoryName;

    public String getCategoryDescription() {
        return categoryDescription;
    }

    public void setCategoryDescription(String categoryDescription) {
        this.categoryDescription = categoryDescription;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    private String categoryDescription;
    List<Product> products;
}
