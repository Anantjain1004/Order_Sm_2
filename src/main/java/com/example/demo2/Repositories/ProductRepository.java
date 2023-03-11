package com.example.demo2.Repositories;

import com.example.demo2.Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {

    List<Product> findProductByNameStartingWith(String name);
    Product findTopByCategoryOrderByPriceDesc(String category);
    List<String> findDistinctByCategory();
    List<Product> findByCategoryOrderByPrice(String category);
}
