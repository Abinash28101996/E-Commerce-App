package com.abinash.eCommerce.services;

import com.abinash.eCommerce.dtos.ProductDto;
import com.abinash.eCommerce.models.Product;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface ProductService {

    List<Product> getProducts();


    Product getSingleProduct(Long productId);


    Product addProduct(ProductDto productDto);


    Product updateProduct(Long productId, Product product);


    Boolean deleteProduct(Long productId);
}
