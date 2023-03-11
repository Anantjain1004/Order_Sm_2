package com.example.demo2.Controllers;

import com.example.demo2.Models.Product;
import com.example.demo2.Models.User;
import com.example.demo2.Services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping("/createOrder")
    public String createOrder(@RequestBody User user){
        return orderService.createOrder(user);
    }

    @GetMapping("maxPice")
    public Product getMaxPrice(@RequestParam String category){
        return orderService.getMaxPrice(category);
    }

    @PostMapping("/lowestPrice")
    public String lowestPrice(@RequestBody User user){
        return orderService.lowestPrice(user);
    }



}
