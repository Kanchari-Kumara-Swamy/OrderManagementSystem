package com.ordermanagementsystem.controller;

import com.ordermanagementsystem.payload.OrderDTO;
import com.ordermanagementsystem.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/{customerId}/getallorders")
    public List<OrderDTO> getAllOrders(@PathVariable Long customerId){
        return orderService.getAllOrders(customerId);
    }

    @GetMapping("/{customerid}/{orderid}")
    public OrderDTO getOrderByID(@PathVariable Long customerid,
                                 @PathVariable Long orderid) {
        return orderService.getOrderById(customerid, orderid);
    }

    @PostMapping(("/{customerId}/createorder"))
    public ResponseEntity<OrderDTO> createOrder(@PathVariable Long customerId,
                                                @RequestBody OrderDTO order) {
        return new ResponseEntity<>(orderService.createOrder(customerId, order), HttpStatus.CREATED);
    }
}
