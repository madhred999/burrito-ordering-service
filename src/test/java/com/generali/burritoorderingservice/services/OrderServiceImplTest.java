package com.generali.burritoorderingservice.services;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.generali.burritoorderingservice.domain.OrderEntity;
import com.generali.burritoorderingservice.model.OrderDto;
import com.generali.burritoorderingservice.repository.OrderRepository;

@ExtendWith(MockitoExtension.class)
public class OrderServiceImplTest {
    
    @Mock
    OrderRepository orderRepository;

    @InjectMocks
    OrderServiceImpl orderService;

    OrderDto orderDto;

    @BeforeEach
    void setup(){
        orderService = new OrderServiceImpl(orderRepository);
        
    }

    @Test
    void createNewOrder_Test(){
        OrderEntity orderEntity = new OrderEntity();
        OrderDto orderDto = new OrderDto();
        orderDto.setTortilla("flour");
        orderDto.setExtras("avocado");
        orderDto.setProtein("bean");
        orderDto.setSalsa("hot");
        orderDto.setVegetables("cabbage");
        orderEntity.setOrderId(Long.valueOf(10));
        when(orderRepository.save(any(OrderEntity.class))).thenReturn(orderEntity);
         orderDto = orderService.createNewOrder(orderDto);
         assertTrue(orderDto.getOrderId().equals(Long.valueOf(10)));
    }

    @Test
    void findById_Test(){
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setOrderId(Long.valueOf(10));
        orderEntity.setProtein("bean");
        orderEntity.setSalsa("hot");
        when(orderRepository.findById(any(Long.class))).thenReturn(Optional.of(orderEntity));
         orderDto = orderService.findOrderById(Long.valueOf(10));
         assertTrue(orderDto.getOrderId().equals(Long.valueOf(10)));
    }
}
