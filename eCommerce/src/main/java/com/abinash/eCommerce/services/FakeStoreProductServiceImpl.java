package com.abinash.eCommerce.services;

import com.abinash.eCommerce.dtos.ProductDto;
import com.abinash.eCommerce.models.Category;
import com.abinash.eCommerce.models.Product;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;


@Service
public class FakeStoreProductServiceImpl implements ProductService{

    private final RestTemplateBuilder restTemplateBuilder;

    public FakeStoreProductServiceImpl(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }

    @Override
    public List<Product> getProducts() {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<ProductDto[]> response = restTemplate.getForEntity("https://fakestoreapi.com/products", ProductDto[].class);
        List<Product> list = new ArrayList<>();
        for(Object obj : response.getBody()) {
            ProductDto productDto = (ProductDto) obj;
            Product product = new Product();
            product.setId(productDto.getId());
            product.setTitle(productDto.getTitle());
            product.setDescription(productDto.getDescription());
            product.setPrice(productDto.getPrice());
            product.setImageURL(productDto.getImage());
            Category category = new Category();
            category.setCategoryName(productDto.getCategory());
            product.setCategory(category);
            list.add(product);
        }
        return list;
    }

    @Override
    public Product getSingleProduct(Long productId) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<ProductDto> response = restTemplate.getForEntity("https://fakestoreapi.com/products/{productId}", ProductDto.class, productId);
        ProductDto productDto = response.getBody();
        Product product = new Product();
        product.setId(productDto.getId());
        product.setTitle(productDto.getTitle());
        product.setDescription(productDto.getDescription());
        product.setPrice(productDto.getPrice());
        product.setImageURL(productDto.getImage());
        Category category = new Category();
        category.setCategoryName(productDto.getCategory());
        product.setCategory(category);
        return product;
    }

    @Override
    public Product addProduct(ProductDto product) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<ProductDto> response = restTemplate.postForEntity("https://fakestoreapi.com/products", product, ProductDto.class);
        ProductDto productDto1 = response.getBody();
        Product product1 = new Product();
        product1.setId(productDto1.getId());
        product1.setTitle(productDto1.getTitle());
        product1.setDescription(productDto1.getDescription());
        product1.setPrice(productDto1.getPrice());
        product1.setImageURL(productDto1.getImage());
        Category category = new Category();
        category.setCategoryName(productDto1.getCategory());
        product1.setCategory(category);
        return product1;
    }

    @Override
    public Product updateProduct(Long productId, Product product) {
        return null;
    }

    @Override
    public Boolean deleteProduct(Long productId) {
        return null;
    }
}
