package com.example.demo2.Models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@Data
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productId;
    private String name;
    private String category;
    private int price;

    @ManyToMany(mappedBy = "product",cascade = CascadeType.ALL)
    private List<Order> orders = new ArrayList<>();
}
