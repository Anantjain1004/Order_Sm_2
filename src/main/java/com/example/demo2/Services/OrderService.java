package com.example.demo2.Services;

import com.example.demo2.Models.Order;
import com.example.demo2.Models.Product;
import com.example.demo2.Models.User;
import com.example.demo2.Repositories.OrderRepository;
import com.example.demo2.Repositories.ProductRepository;
import com.example.demo2.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    ProductRepository productRepository;


    public String createOrder(User user) {
        List<Product> products = productRepository.findProductByNameStartingWith("A");
        Order order = new Order();
        order.setUser(user);
        List <Product> products1 = order.getProducts();
        for (Product product: products){
            products1.add(product);
        }
        order.setProducts(products1);
        order.setPaymentMode("COD");

        List<Order> orders = user.getOrders();
        orders.add(order);
        user.setOrders(orders);

         orderRepository.save(order);
        userRepository.save(user);


        return "Order created";
    }

    public Product getMaxPrice(String category) {
        return productRepository.findTopByCategoryOrderByPriceDesc(category);
    }


    public String lowestPrice(User user){

        List<String> categories = productRepository.findDistinctByCategory();
        List<Product> lowPrice = new ArrayList<>();
        for (String category: categories){
            List<Product> productsInCateg = productRepository.findByCategoryOrderByPrice(category);
            if(!productsInCateg.isEmpty()){
                lowPrice.add(productsInCateg.get(0));
            }
        }

        Order order = new Order();
        order.setUser(user);
        order.setProducts(lowPrice);
        order.setPaymentMode("Online");
        List<Order> orders = user.getOrders();
        orders.add(order);
        user.setOrders(orders);
        userRepository.save(user);
        return "Order Created";
    }



}
