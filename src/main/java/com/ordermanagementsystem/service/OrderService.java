package com.ordermanagementsystem.service;

import com.ordermanagementsystem.entity.Customer;
import com.ordermanagementsystem.entity.Order;
import com.ordermanagementsystem.payload.OrderDTO;

import java.util.List;

public interface OrderService {

    List<OrderDTO> getAllOrders(Long customerId);

    OrderDTO getOrderById(Long customerId, Long orderId);

    OrderDTO createOrder(Long customerId, OrderDTO order);

}
