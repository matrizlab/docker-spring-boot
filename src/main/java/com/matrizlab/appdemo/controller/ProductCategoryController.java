package com.matrizlab.appdemo.controller;

import com.matrizlab.appdemo.model.ProductCategoryModel;
import com.matrizlab.appdemo.repository.ProductCategoryRepositoy;
import com.matrizlab.appdemo.repository.ProductRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductCategoryController {

    @Autowired
    private ProductCategoryRepositoy productCategoryRepository;
    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/categories")
    public List<ProductCategoryModel> getAllProductCategory() {
        return productCategoryRepository.findAll();
    }

    @GetMapping("/categories/{id}")
    public ProductCategoryModel getProductCategory(@PathVariable String id) {
        return productCategoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Cannot Find Product Category By ID: " + id));
    }

    @PostMapping("/categories")
    public ResponseEntity<String> saveProductCategory(@RequestBody ProductCategoryModel categoryModel) {
        ProductCategoryModel savedProduct = productCategoryRepository.insert(categoryModel);//it will create new document in table with autogenerated id, if id exist than exception in is thrown
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedProduct.getId())
                .toUri();
        //http://localhost:8081/api/categories/611b7bcfef59e87f2e0e0d60
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/categories/{id}")
    public ResponseEntity<ProductCategoryModel> updateProductCategory(@PathVariable String id, @RequestBody ProductCategoryModel Product) {
        ProductCategoryModel imFromDB = productCategoryRepository.findById(id).orElseThrow(()->new RuntimeException("Cannot Find Product Category By ID: " + id));
        BeanUtils.copyProperties(Product, imFromDB);//copy all data from Product to imFromDB
        imFromDB = productCategoryRepository.save(imFromDB);//if request has id than it will update else it will insert new document with new autogenerated id
        return new ResponseEntity<>(imFromDB, HttpStatus.OK);
    }

    @DeleteMapping("/categories/{id}")
    public ResponseEntity<String> deleteProductCategory(@PathVariable String id) {
        //List<ProductModel> productModels = ProductRepository.findAllByCategoryId(id);
        productRepository.deleteAllByCategoryId(id);
        productCategoryRepository.deleteById(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}
