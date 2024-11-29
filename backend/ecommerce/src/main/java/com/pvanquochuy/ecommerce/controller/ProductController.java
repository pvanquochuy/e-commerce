package com.pvanquochuy.ecommerce.controller;

import com.pvanquochuy.ecommerce.exception.ProductException;
import com.pvanquochuy.ecommerce.model.Product;
import com.pvanquochuy.ecommerce.service.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {
    private ProductService productService;

    @GetMapping("/product")
    public ResponseEntity<Page<Product>> findProductByCategoryHandle(
            @RequestParam String category, @RequestParam List<String> color, @RequestParam List<String> size,
            @RequestParam Integer minPrice, @RequestParam Integer maxPrice, @RequestParam Integer minDiscount,
            @RequestParam String sort, @RequestParam String stock, @RequestParam Integer pageNumber, @RequestParam Integer pageSize){
        Page<Product> res = productService.getAllProduct(
                category, color, size, minPrice, maxPrice, minDiscount, sort, stock, pageNumber ,pageSize
        );
        return new ResponseEntity<>(res, HttpStatus.ACCEPTED);
    }

    @GetMapping("/products/id/{productId}")
    public ResponseEntity<Product> findProductByIdHandler(@PathVariable Long productId) throws ProductException{
        Product product = productService.findProductById(productId);

        return new ResponseEntity<Product>(product, HttpStatus.ACCEPTED);
    }



}