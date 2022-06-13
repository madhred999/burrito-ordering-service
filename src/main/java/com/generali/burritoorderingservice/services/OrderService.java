package com.generali.burritoorderingservice.services;

import com.generali.burritoorderingservice.model.OrderDto;

public interface OrderService {
    OrderDto findOrderById(Long orderId);

    OrderDto createNewOrder(OrderDto order);
    
}
