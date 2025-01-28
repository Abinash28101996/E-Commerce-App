package com.abinash.eCommerce.dtos;

import com.abinash.eCommerce.models.Product;

public class AddProductResponseDto {
    private Product product;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
