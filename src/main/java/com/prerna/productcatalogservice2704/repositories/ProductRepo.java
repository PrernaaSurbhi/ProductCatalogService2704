package com.prerna.productcatalogservice2704.repositories;

import com.prerna.productcatalogservice2704.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends JpaRepository<Product,Long> {

}
