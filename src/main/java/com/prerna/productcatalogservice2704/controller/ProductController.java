package com.prerna.productcatalogservice2704.controller;

import com.prerna.productcatalogservice2704.dtos.ProductDTO;
import com.prerna.productcatalogservice2704.model.Product;
import com.prerna.productcatalogservice2704.services.IProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class ProductController {

    IProductService productService;

    public ProductController(IProductService iProductService){
        this.productService = iProductService;
    }

    @GetMapping("/products/{id}")
    ResponseEntity<ProductDTO> getProductById(@PathVariable("id") Long id){

        Product product =  productService.getProductById(id);
        if (product == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(product.toProductDto());

    }

    @PostMapping("/product")
    public ProductDTO createProduct(@RequestBody ProductDTO product){
        return null;
    }
}
