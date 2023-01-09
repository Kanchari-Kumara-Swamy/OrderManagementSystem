package com.ordermanagementsystem.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO{

    private int id;
    private String name;
    private String email;
    private String password;

    private String tier;

    private int total_orders;

    private Set<OrderDTO> orders;
}
