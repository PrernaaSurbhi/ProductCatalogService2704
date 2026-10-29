package com.prerna.productcatalogservice2704.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.prerna.productcatalogservice2704.dtos.CategoryDTO;
import com.prerna.productcatalogservice2704.dtos.FakestoreProductDto;
import com.prerna.productcatalogservice2704.dtos.ProductDTO;
import org.springframework.http.ResponseEntity;

public class Product extends BaseModel{
    private String name;
    private String description;
    private Double price;
    private String imageUrl;
    private Category category;


    public ProductDTO toProductDto(){
        ProductDTO productDto = new ProductDTO();
        productDto.setId(this.getId());
        productDto.setName(this.getName());
        productDto.setDescription(this.getDescription());
        productDto.setPrice(this.getPrice());
        productDto.setImageUrl(this.getImageUrl());
        if(this.getCategory() != null) {
            CategoryDTO categoryDto = new CategoryDTO();
            categoryDto.setName(this.getCategory().getName());
            categoryDto.setId(this.getCategory().getId());
            categoryDto.setDescription(this.getCategory().getDescription());
            productDto.setCategory(categoryDto);
        }
        return productDto;

    }

    public FakestoreProductDto toFakestoreProductDto(){
         /*
        This method is used to convert the Product object to a FakestoreProductDto object.
         */
        FakestoreProductDto fakestoreProductDto = new FakestoreProductDto();
        fakestoreProductDto.setId(this.getId());
        fakestoreProductDto.setTitle(this.name);
        fakestoreProductDto.setDescription(this.description);
        fakestoreProductDto.setPrice(this.price);
        fakestoreProductDto.setImage(this.imageUrl);
        fakestoreProductDto.setCategory(this.category.getName());

        return fakestoreProductDto;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

}
