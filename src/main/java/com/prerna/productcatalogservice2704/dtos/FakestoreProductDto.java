package com.prerna.productcatalogservice2704.dtos;

import com.prerna.productcatalogservice2704.model.Category;
import com.prerna.productcatalogservice2704.model.Product;

public class FakestoreProductDto {

    private Long id;
    private String title;
    private String description;
    private String image;
    private Double price;
    private String category;

    public Product toProduct(){

        Product product = new Product();
        product.setId(this.id);
        product.setName(this.title);
        product.setDescription(this.description);
        product.setPrice(this.price);
        product.setImageUrl(this.image);

        /*
        fakestore mein category is a string
        but in our product, categorys is not a string
         */

        Category category = new Category();
        category.setName(this.category);
        product.setCategory(category);

        return product;

    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

}
