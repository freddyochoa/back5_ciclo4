package com.ciclo4.ciclo4_reto2.repository;

import com.ciclo4.ciclo4_reto2.model.Product;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.ciclo4.ciclo4_reto2.repository.crud.ProductCrudRepository;

@Repository
public class ProductRepository {
    @Autowired
    private ProductCrudRepository productCrudRepository;

    public List<Product> getAll(){
        return productCrudRepository.findAll();
    }

    public Optional<Product> getProduct(String id){
        return productCrudRepository.findById(id);
    }

    public Product create(Product product){
        return productCrudRepository.save(product);
    }

    public void update(Product product){
        productCrudRepository.save(product);
    }

    public void delete(Product product){
        productCrudRepository.delete(product);
    }
    public List<Product>getByPrice(double price){
       return productCrudRepository.findByPrice(price);
    }

    public List<Product>getByDescriptionContainingIgnoreCase(String description){
        return productCrudRepository.findByDescriptionContainingIgnoreCase(description);
    }
}
