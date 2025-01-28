package com.abinash.eCommerce.controllers;

import com.abinash.eCommerce.dtos.AddProductResponseDto;
import com.abinash.eCommerce.dtos.ProductDto;
import com.abinash.eCommerce.dtos.SingleProductResponseDto;
import com.abinash.eCommerce.models.Category;
import com.abinash.eCommerce.models.Product;
import com.abinash.eCommerce.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping()
    public List<Product> getProducts(){
        return productService.getProducts();
    }

    @GetMapping("/{productId}")
    public ResponseEntity<SingleProductResponseDto> getSingleProduct(@PathVariable("productId") Long productId){
        SingleProductResponseDto singleProductResponseDto = new SingleProductResponseDto();
        singleProductResponseDto.setProduct(productService.getSingleProduct(productId));
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.add("auth-token",  "noAccessBuddy");
        headers.add("Behaviour",  "Bad");
        ResponseEntity<SingleProductResponseDto> response = new ResponseEntity<>(singleProductResponseDto, headers, HttpStatus.NOT_FOUND);


        return response;
    }

    @PostMapping()
    public ResponseEntity<Product> addProduct(@RequestBody ProductDto productDto){
        Product product = productService.addProduct(productDto);
        return new ResponseEntity<>(product, HttpStatus.CREATED);
    }

    @PatchMapping("/{productId}")
    public String updateProduct(@PathVariable("productId") Long productId, @RequestBody ProductDto productDto){
        return null;
    }

    @DeleteMapping("/{productId}")
    public String deleteProduct(@PathVariable("productId") Long productId){
        return "The product with id " + productId + " was deleted";
    }
}
