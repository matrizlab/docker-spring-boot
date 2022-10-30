package com.matrizlab.appdemo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "ProductCategoryModel")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductCategoryModel {
    private String id;
    private String name;
}
