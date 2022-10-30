package com.matrizlab.appdemo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Product")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductModel {
    private String id;
    private String name;
    private String description;
    private Double price;
    private String categoryId;
}
