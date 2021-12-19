package com.ciclo4.ciclo4_reto2.web;

import com.ciclo4.ciclo4_reto2.model.Product;
import com.ciclo4.ciclo4_reto2.service.ProductService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/accessory")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/all")
    public List<Product> getAll(){
        return productService.getAll();
    }

    @GetMapping("/{reference}")
    public Optional<Product> getCleaningProduct(@PathVariable("reference") String reference) {
        return productService.getCleaningProducts(reference);
    }
    
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody Product product){
        productService.create(product);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Product update(@RequestBody Product product){
        return productService.update(product);
    }

    @DeleteMapping("/{reference}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("reference") String reference){
        return productService.delete(reference);
    }
    @GetMapping("/price/{price}")
    public List<Product>getByPrice(@PathVariable("price")double price){
        return productService.getByPrice(price);
    }
    @GetMapping("/description/{description}")
    public List<Product>getByByDescriptionContainingIgnoreCase(@PathVariable("description") String description){
        return productService.getByDescriptionContainingIgnoreCase(description);
    }

}

