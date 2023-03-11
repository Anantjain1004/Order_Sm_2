package com.example.demo2.Controllers;

import com.example.demo2.Models.Product;
import com.example.demo2.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping("/addProduct")
    public String add(Product product){
        return productService.add(product);
    }
}
