package com.prerna.productcatalogservice2704.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.util.List;

public class Category extends BaseModel{
    private String name;
    private String description;
    private List<Product> products;

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

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

}
