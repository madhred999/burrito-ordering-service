package com.generali.burritoorderingservice.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="Orders")
@Data
public class OrderEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long orderId;
 
    @Column(name = "tortilla")
    private String tortilla;

    @Column(name = "protein")
    private String protein;

    @Column(name = "salsa")
    private String salsa;

    @Column(name = "vegetables")
    private String vegetables;

    @Column(name = "extras")
    private String extras;

    public OrderEntity() {
    }

}
