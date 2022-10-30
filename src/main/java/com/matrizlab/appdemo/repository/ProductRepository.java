package com.matrizlab.appdemo.repository;

import com.matrizlab.appdemo.model.ProductModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<ProductModel, String> {
    public void deleteAllByCategoryId(String categoryId);
    //public List<ProductModel> findAllByCategoryId(String categoryId);
}
