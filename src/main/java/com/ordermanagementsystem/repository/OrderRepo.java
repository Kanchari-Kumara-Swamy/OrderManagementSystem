package com.ordermanagementsystem.repository;

import com.ordermanagementsystem.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepo extends JpaRepository<Order, Long> {

    List<Order> findByCustomerId(Long customerId);
}
