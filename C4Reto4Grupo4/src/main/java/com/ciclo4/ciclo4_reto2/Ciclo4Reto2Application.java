package com.ciclo4.ciclo4_reto2;

import com.ciclo4.ciclo4_reto2.repository.crud.OrderCrudRepository;
import com.ciclo4.ciclo4_reto2.repository.crud.UserCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import com.ciclo4.ciclo4_reto2.repository.crud.ProductCrudRepository;

@Component
@SpringBootApplication
public class Ciclo4Reto2Application implements CommandLineRunner{
    @Autowired
    private ProductCrudRepository productCrudRepository;
    
    @Autowired
    private UserCrudRepository userCrudRepository;
    
    @Autowired
    private OrderCrudRepository orderCrudRepository;
    public static void main(String[] args) {
    SpringApplication.run(Ciclo4Reto2Application.class, args);
    }
    
    @Override
    public void run(String... args) throws Exception {
        productCrudRepository.deleteAll();
        userCrudRepository.deleteAll();
        orderCrudRepository.deleteAll();
    }

}
