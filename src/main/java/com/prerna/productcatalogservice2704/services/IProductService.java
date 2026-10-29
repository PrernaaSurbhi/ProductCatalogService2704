package com.prerna.productcatalogservice2704.services;

import com.prerna.productcatalogservice2704.dtos.ProductDTO;
import com.prerna.productcatalogservice2704.model.Product;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface IProductService {

    List<Product> getAllProduct();

    Product getProductById(@PathVariable("id") Long id);

    ProductDTO createProduct(@RequestBody ProductDTO product);

    Product replaceProduct(Product newProduct, Long id);

}
