package com.prerna.productcatalogservice2704.services;

import com.prerna.productcatalogservice2704.dtos.FakestoreProductDto;
import com.prerna.productcatalogservice2704.dtos.ProductDTO;
import com.prerna.productcatalogservice2704.model.Product;
import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service("fakestore")
public class FakestoreProductService implements IProductService{

    @Autowired
    private RestTemplate restTemplate;

    public <T> ResponseEntity<T> putForEntity(String url, @Nullable Object request, Class<T> responseType, Object... uriVariables) throws RestClientException {
        RequestCallback requestCallback = restTemplate.httpEntityCallback(request, responseType);
        ResponseExtractor<ResponseEntity<T>> responseExtractor = restTemplate.responseEntityExtractor(responseType);
        return restTemplate.execute(url, HttpMethod.PUT, requestCallback, responseExtractor, uriVariables);
    }

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

    @Override
    public Product replaceProduct(Product newProduct, Long id) {

        ResponseEntity<FakestoreProductDto> fakestoreProductDto =
                putForEntity(
                        "https://fakestoreapi.com/products/{id}",
                        newProduct.toFakestoreProductDto(),
                        FakestoreProductDto.class,
                        id
                );

        if(fakestoreProductDto.getBody() != null
                && fakestoreProductDto.getStatusCode().equals(200)){

            return fakestoreProductDto.getBody().toProduct();

        }


        return null;
    }


}
