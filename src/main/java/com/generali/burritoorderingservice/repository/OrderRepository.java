package com.generali.burritoorderingservice.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.generali.burritoorderingservice.domain.OrderEntity;

public interface OrderRepository extends CrudRepository<OrderEntity, Long> {

    Optional<OrderEntity> findById(Long orderId);

    <T extends OrderEntity> T save(T order);
    
}
