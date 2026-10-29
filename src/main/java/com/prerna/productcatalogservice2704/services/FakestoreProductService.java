package com.prerna.productcatalogservice2704.services;

import com.prerna.productcatalogservice2704.dtos.FakestoreProductDto;
import com.prerna.productcatalogservice2704.dtos.ProductDTO;
import com.prerna.productcatalogservice2704.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service("fakestore")
public class FakestoreProductService implements IProductService{

    @Autowired
    private RestTemplate restTemplate;

    // /products
    // GET
    @Override
    public List<Product> getAllProduct() {

        List<Product> productList = new ArrayList<>();

        ResponseEntity<FakestoreProductDto[]> fakeStoreProductDtoList = restTemplate.getForEntity(
                "https://fakestoreapi.com/products",
                FakestoreProductDto[].class
        );

        if(fakeStoreProductDtoList.getBody() != null
                && fakeStoreProductDtoList.getStatusCode().equals(HttpStatusCode.valueOf(200))){

            for(FakestoreProductDto fakestoreProductDto : fakeStoreProductDtoList.getBody()){
                productList.add(fakestoreProductDto.toProduct());
            }

            return productList;
        }

        return productList;
    }

    @Override
    public Product getProductById(Long id) {

        ResponseEntity<FakestoreProductDto> fakestoreProductDto = restTemplate.getForEntity(
                "https://fakestoreapi.com/products/{id}",
                FakestoreProductDto.class,
                id
        );

        if(fakestoreProductDto.getStatusCode().equals(HttpStatusCode.valueOf(200))){
            if(fakestoreProductDto.getBody() != null){
                return fakestoreProductDto.getBody().toProduct();
            }else{
                return null;
            }
        }else{
            return null;
        }

    }

    @Override
    public ProductDTO createProduct(ProductDTO product) {
        return null;
    }


}
