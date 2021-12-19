package com.ciclo4.ciclo4_reto2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "products")
public class Product {
	@Id
        private String reference;
        private String brand;
        private String category;
        private String material;
        private String gender;
        private String size;
        private String description;
        private boolean availability = true;
        private double price;
        private Integer quantity;
        private String photography;

}
