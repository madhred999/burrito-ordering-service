package com.generali.burritoorderingservice.services;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;

import com.generali.burritoorderingservice.domain.OrderEntity;
import com.generali.burritoorderingservice.model.OrderDto;
import com.generali.burritoorderingservice.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository){
        this.orderRepository = orderRepository;
    }

    @Override
    public OrderDto findOrderById(Long orderId) {
        Optional<OrderEntity> orderEntity = orderRepository.findById(orderId);
        OrderDto orderDto = new OrderDto();
            //TO-DO  - write a mapper
        orderEntity.ifPresent( order -> {            
            orderDto.setOrderId(order.getOrderId());
            orderDto.setProtein(order.getProtein());
            orderDto.setExtras(order.getExtras());
            orderDto.setSalsa(order.getSalsa());
            orderDto.setVegetables(order.getVegetables());
            orderDto.setTortilla(order.getTortilla());
        } );

    //TO-DO  - throw custom exception when order is not found
        return orderDto;
    }

    @Override
    public OrderDto createNewOrder(OrderDto order) {
        
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setProtein(order.getProtein());
        orderEntity.setSalsa(order.getSalsa());
        orderEntity.setTortilla(order.getTortilla());
        orderEntity.setExtras(order.getExtras());
        orderEntity.setVegetables(order.getVegetables());
        orderEntity =  orderRepository.save(orderEntity);
        order.setOrderId(orderEntity.getOrderId());
        return order;

    }
    
}
