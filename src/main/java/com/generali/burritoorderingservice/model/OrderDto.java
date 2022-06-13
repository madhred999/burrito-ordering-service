package com.generali.burritoorderingservice.model;

import java.util.List;

import lombok.Data;

@Data
public class OrderDto {
    private Long orderId;
    private String tortilla;
    private String protein;
    private String vegetables;
    private String salsa;
    private String extras;

}
