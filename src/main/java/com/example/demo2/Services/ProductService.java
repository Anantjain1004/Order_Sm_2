package com.example.demo2.Services;

import com.example.demo2.Models.Product;
import com.example.demo2.Repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public String add(Product product){
        productRepository.save(product);
        return "Product added successfully";
    }

}
