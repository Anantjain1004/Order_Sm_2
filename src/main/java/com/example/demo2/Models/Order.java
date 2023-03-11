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
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderId;
    private String paymentMode;

    @ManyToOne
    @JoinColumn
    private User user;

    @ManyToMany
    @JoinColumn
    private List<Product> products = new ArrayList<>();

}
