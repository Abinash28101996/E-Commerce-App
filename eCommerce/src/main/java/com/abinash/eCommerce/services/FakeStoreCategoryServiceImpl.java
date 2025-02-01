package com.abinash.eCommerce.services;

import com.abinash.eCommerce.clients.FakeStoreProductDto;
import com.abinash.eCommerce.models.Category;
import com.abinash.eCommerce.models.Product;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreCategoryServiceImpl implements CategoryService{
    RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder();
    public FakeStoreCategoryServiceImpl(RestTemplateBuilder restTemplateBuilder){
        this.restTemplateBuilder = restTemplateBuilder;
    }

    @Override
    public List<Product> getProductsInCategory(String categories) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto[]> response = restTemplate.getForEntity("https://fakestoreapi.com/products/category/{category}", FakeStoreProductDto[].class, categories);
        List<Product> products = new ArrayList<>();
        for(Object obj: response.getBody()){
            FakeStoreProductDto fakeStoreProductDto = (FakeStoreProductDto)obj;
            Product product = new Product();
            product.setId(fakeStoreProductDto.getId());
            product.setTitle(fakeStoreProductDto.getTitle());
            product.setDescription(fakeStoreProductDto.getDescription());
            product.setPrice(fakeStoreProductDto.getPrice());
            Category category = new Category();
            category.setCategoryName(fakeStoreProductDto.getCategory());
            product.setCategory(category);
            products.add(product);
        }
        return products;
    }


    @Override
    public List<String> getAllCategories(){
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<String[]> response = restTemplate.getForEntity("https://fakestoreapi.com/products/categories", String[].class);
        List<String> categories = new ArrayList<>();
        for(Object obj: response.getBody()){
            categories.add((String)obj);
        }
        return categories;
    }
}
