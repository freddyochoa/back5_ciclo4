package com.ciclo4.ciclo4_reto2.service;

import com.ciclo4.ciclo4_reto2.model.Product;
import com.ciclo4.ciclo4_reto2.repository.ProductRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAll(){
        return productRepository.getAll();
    }

    public Optional<Product> getCleaningProducts(String reference){
        return productRepository.getProduct(reference);
    }

    public Product create(Product cleaningProduct){
        if (cleaningProduct.getReference()== null){
            return cleaningProduct;
        }else{
            return productRepository.create(cleaningProduct);
        }
    }

    public Product update(Product product){
        if (product.getReference()!= null){
            Optional<Product> dbProduct = productRepository.getProduct(product.getReference());
            if (dbProduct.isPresent()){
                if (product.getBrand()!= null){
                    dbProduct.get().setBrand(product.getBrand());
                }
                if (product.getCategory()!= null){
                    dbProduct.get().setCategory(product.getCategory());
                }
                if (product.getMaterial()!= null){
                    dbProduct.get().setMaterial(product.getMaterial());
                }
                if (product.getGender()!= null){
                    dbProduct.get().setGender(product.getGender());
                }
                if (product.getSize()!= null){
                    dbProduct.get().setSize(product.getSize());
                }
                if (product.getDescription() != null){
                    dbProduct.get().setDescription(product.getDescription());
                }

                dbProduct.get().setAvailability(product.isAvailability());

                if (product.getPrice()!= 0.0){
                    dbProduct.get().setPrice(product.getPrice());
                }
                if (product.getQuantity()!= 0){
                    dbProduct.get().setQuantity(product.getQuantity());
                }
                if (product.getPhotography()!= null){
                    dbProduct.get().setPhotography(product.getPhotography());
                }
                productRepository.update(dbProduct.get());
                return dbProduct.get();
            } else {
                return product;
            }
        } else {
            return product;
        }
    }

    public boolean delete(String reference){
        Boolean aboolean = getCleaningProducts(reference).map(cleaningProduct -> {
            productRepository.delete(cleaningProduct);
            return true;
        }).orElse(false);
        return aboolean;
    }
    public List<Product>getByPrice(double price){
        return productRepository.getByPrice(price);
    }
    public List<Product>getByDescriptionContainingIgnoreCase(String description){
        return productRepository.getByDescriptionContainingIgnoreCase(description);
    }
}
