package com.ciclo4.ciclo4_reto2.repository.crud;

import com.ciclo4.ciclo4_reto2.model.Product;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface ProductCrudRepository extends MongoRepository<Product, String> {
    public List<Product>findByPrice(double price);

    public List<Product>findByDescriptionContainingIgnoreCase(String description);



}

