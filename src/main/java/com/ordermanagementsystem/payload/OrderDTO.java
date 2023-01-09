package com.ordermanagementsystem.payload;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {

    private Long id;
    private String item_name;
    private Integer quantity;
    private Long item_price;
    private Double total;
}
