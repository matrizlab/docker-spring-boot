package com.matrizlab.appdemo.repository;

import com.matrizlab.appdemo.model.ProductCategoryModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductCategoryRepositoy extends MongoRepository<ProductCategoryModel, String> {
}
