package com.example.demo.batch;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class Product {
    private Long id;
    private String name;
    private String description;
    private int price;
}
