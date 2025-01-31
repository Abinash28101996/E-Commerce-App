package com.abinash.eCommerce.services;

import com.abinash.eCommerce.dtos.FakeStoreProductDto;
import com.abinash.eCommerce.dtos.ProductDto;
import com.abinash.eCommerce.exceptions.NotFoundException;
import com.abinash.eCommerce.models.Category;
import com.abinash.eCommerce.models.Product;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class FakeStoreProductServiceImpl implements ProductService{

    private final RestTemplateBuilder restTemplateBuilder;

    public FakeStoreProductServiceImpl(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }

    private <T> ResponseEntity<T> requestForEntity(String url, @Nullable Object request, Class<T> responseType, Object... uriVariables) throws RestClientException {
        RestTemplate restTemplate = restTemplateBuilder.build();
        RequestCallback requestCallback = restTemplate.httpEntityCallback(request, responseType);
        ResponseExtractor<ResponseEntity<T>> responseExtractor = restTemplate.responseEntityExtractor(responseType);
        return restTemplate.execute(url, HttpMethod.PUT, requestCallback, responseExtractor, uriVariables);
    }

    private Product convertFakeProductDtoToProduct(FakeStoreProductDto productDto) {
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
    public List<Product> getProducts() {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto[]> response = restTemplate.getForEntity("https://fakestoreapi.com/products", FakeStoreProductDto[].class);
        List<Product> list = new ArrayList<>();
        for(Object obj : response.getBody()) {
            FakeStoreProductDto productDto = (FakeStoreProductDto) obj;
            Product product = convertFakeProductDtoToProduct(productDto);
            list.add(product);
        }
        return list;
    }

    @Override
    public Optional<Product> getSingleProduct(Long productId) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> response = restTemplate.getForEntity("https://fakestoreapi.com/products/{productId}", FakeStoreProductDto.class, productId);
        FakeStoreProductDto productDto = response.getBody();

        if(productDto == null) {
            return Optional.empty();
        }
        Product product = convertFakeProductDtoToProduct(productDto);
        return Optional.of(product);
    }

    @Override
    public Product addProduct(ProductDto product) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> response = restTemplate.postForEntity("https://fakestoreapi.com/products", product, FakeStoreProductDto.class);
        FakeStoreProductDto productDto = response.getBody();
        Product product1 = convertFakeProductDtoToProduct(productDto);
        return product1;
    }

    @Override
    public Product updateProduct(Long productId, Product product) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        FakeStoreProductDto fakeStoreProductDto = new FakeStoreProductDto();
        fakeStoreProductDto.setId(productId);
        fakeStoreProductDto.setTitle(product.getTitle());
        fakeStoreProductDto.setDescription(product.getDescription());
        fakeStoreProductDto.setPrice(product.getPrice());
        fakeStoreProductDto.setCategory(product.getCategory().getCategoryName());
        ResponseEntity<FakeStoreProductDto> response = requestForEntity("https://fakestoreapi.com/products/{productId}", fakeStoreProductDto, FakeStoreProductDto.class, productId );
        return convertFakeProductDtoToProduct(response.getBody());
    }

    @Override
    public Boolean deleteProduct(Long productId) {
        return null;
    }
}
