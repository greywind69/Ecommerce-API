package com.example.Ecommerce.API.Controller;

import com.example.Ecommerce.API.Model.Address;
import com.example.Ecommerce.API.Model.Product;
import com.example.Ecommerce.API.Model.User;
import com.example.Ecommerce.API.Repository.AddRepository;
import com.example.Ecommerce.API.Repository.ProdRepository;
import com.example.Ecommerce.API.Repository.UserRepository;
import com.example.Ecommerce.API.Service.OrderService;

import com.example.Ecommerce.API.Model.Order;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class OrderController {
    @Autowired
    OrderService orderService;
    @Autowired
    UserRepository userRepository;
    @Autowired
    ProdRepository productRepository;
    @Autowired
    AddRepository addressRepository;

    @PostMapping("/placeOrder")
    public ResponseEntity placeOrder(@RequestBody String order){
        JSONObject jsonObject = new JSONObject(order);
        Order order1 = validateOrder(jsonObject);
        String response = orderService.makingOrder(order1);
        return new ResponseEntity<>(response, HttpStatus.CREATED);

    }

    private Order validateOrder(JSONObject json){
        Order order = new Order();
        order.setOrdersId(json.getInt("orderId"));
        if(json.has("userId")) {
            User user = userRepository.findById(json.getInt("userId")).orElse(null);
            order.setUser(user);
        }
        if(json.has("productId")){
            Product product = productRepository.findById(json.getInt("productId")).orElse(null);
            order.setProduct(product);
        }
        if(json.has("addressId")){
            Address address = addressRepository.findById(json.getInt("addressId")).orElse(null);
            order.setAddress(address);
        }
        order.setProductQuantity(json.getInt("productQuantity"));
        return order;
    }

    @GetMapping("/getOrder/{ordersId}")
    public Order getOrders(@PathVariable Integer ordersId){
        return orderService.get(ordersId);
    }
}