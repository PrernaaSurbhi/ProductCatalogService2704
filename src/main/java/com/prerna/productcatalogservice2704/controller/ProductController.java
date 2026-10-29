package com.prerna.productcatalogservice2704.controller;

import com.prerna.productcatalogservice2704.dtos.ProductDTO;
import com.prerna.productcatalogservice2704.model.Product;
import com.prerna.productcatalogservice2704.services.IProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;


@RestController
public class ProductController {

    IProductService productService;

    public ProductController(IProductService iProductService){
        this.productService = iProductService;
    }

    @GetMapping("/products/{id}")
    ResponseEntity<ProductDTO> getAllProductById(@PathVariable("id") Long id){

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



    @GetMapping("/products")
    List<ProductDTO>  getAllProduct(){

        List<Product> products =  productService.getAllProduct();

        List<ProductDTO> productDTOS = new ArrayList<>();

        for(Product product: products){
            productDTOS.add(product.toProductDto());
        }

        return productDTOS;
    }


    @PutMapping("/products/{id}")
    public ProductDTO replaceProduct(@PathVariable("id") Long productId,
                                     @RequestBody ProductDTO productDTO){

        Product product = productDTO.toProduct();

        Product response = productService.replaceProduct(
                product,
                productId
        );

        return response.toProductDto();

    }

}
