package com.example.Ecommerce.API.Service;
import com.example.Ecommerce.API.Repository.OrderRepository;
import com.example.Ecommerce.API.Model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;

    public String makingOrder(Order order){
        orderRepository.save(order);
        return "Given Order Is Placed";
    }

    public Order get(Integer ordersId) {
        return orderRepository.findById(ordersId).get();
    }
}