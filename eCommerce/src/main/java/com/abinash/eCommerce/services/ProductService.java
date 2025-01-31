package com.abinash.eCommerce.services;

import com.abinash.eCommerce.dtos.ProductDto;
import com.abinash.eCommerce.models.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    List<Product> getProducts();


    Optional<Product> getSingleProduct(Long productId);


    Product addProduct(ProductDto productDto);


    Product updateProduct(Long productId, Product product);


    Boolean deleteProduct(Long productId);
}
