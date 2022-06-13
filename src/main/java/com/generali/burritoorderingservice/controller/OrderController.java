package com.generali.burritoorderingservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.generali.burritoorderingservice.model.OrderDto;
import com.generali.burritoorderingservice.services.OrderService;

@RestController
public class OrderController {

  private final OrderService orderService;

  OrderController(OrderService orderService){
    this.orderService = orderService;
  }

  @PostMapping("/orders")
  OrderDto createNewOrder(@RequestBody OrderDto order) {
    //TO-DO add validations
    return orderService.createNewOrder(order);
  }
  
  @GetMapping("/orders/{orderId}")
  OrderDto findOrderById(@PathVariable Long orderId) {
    return orderService.findOrderById(orderId);
    }
}
