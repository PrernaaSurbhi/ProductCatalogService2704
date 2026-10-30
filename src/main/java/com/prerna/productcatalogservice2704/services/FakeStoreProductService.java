package com.prerna.productcatalogservice2704.services;

import com.prerna.productcatalogservice2704.clients.FakeStoreAPIClient;
import com.prerna.productcatalogservice2704.dtos.FakestoreProductDto;
import com.prerna.productcatalogservice2704.dtos.ProductDTO;
import com.prerna.productcatalogservice2704.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("fakestore")
public class FakeStoreProductService implements IProductService {

    @Autowired
    FakeStoreAPIClient fakestoreAPIClient;

    // GET
    @Override
    public List<Product> getAllProduct() {

        List<Product> productList = new ArrayList<>();

        ResponseEntity<FakestoreProductDto[]> fakeStoreProductDtoList = fakestoreAPIClient.requestForEntity(
                "https://fakestoreapi.com/products",
                HttpMethod.GET,
                null,
                FakestoreProductDto[].class
        );

        if (fakeStoreProductDtoList.getBody() != null
                && fakeStoreProductDtoList.getStatusCode().equals(HttpStatusCode.valueOf(200))) {

            for (FakestoreProductDto fakestoreProductDto : fakeStoreProductDtoList.getBody()) {
                productList.add(fakestoreProductDto.toProduct());
            }

            return productList;
        }

        return productList;
    }

    @Override
    public Product getProductById(Long id) {

        ResponseEntity<FakestoreProductDto> fakestoreProductDto = fakestoreAPIClient.requestForEntity(
                "https://fakestoreapi.com/products/{id}",
                HttpMethod.GET,
                null,
                FakestoreProductDto.class,
                id
        );

        if (fakestoreProductDto.getStatusCode().equals(HttpStatusCode.valueOf(200))) {
            if (fakestoreProductDto.getBody() != null) {
                return fakestoreProductDto.getBody().toProduct();
            } else {
                return null;
            }
        } else {
            return null;
        }

    }

    @Override
    public ProductDTO createProduct(ProductDTO product) {
        return null;
    }

    @Override
    public Product replaceProduct(Product newProduct, Long id) {

        ResponseEntity<FakestoreProductDto> fakestoreProductDto =
                fakestoreAPIClient.requestForEntity(
                        "https://fakestoreapi.com/products/{id}",
                        HttpMethod.PUT,
                        newProduct.toFakestoreProductDto(),
                        FakestoreProductDto.class,
                        id
                );

        if (fakestoreProductDto.getBody() != null
                && fakestoreProductDto.getStatusCode().equals(200)) {

            return fakestoreProductDto.getBody().toProduct();

        }

        return null;
    }

}
