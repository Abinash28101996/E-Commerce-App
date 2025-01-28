package com.abinash.eCommerce.dtos;

import com.abinash.eCommerce.models.Product;
import lombok.Getter;
import lombok.Setter;


public class SingleProductResponseDto {
    private Product product;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
