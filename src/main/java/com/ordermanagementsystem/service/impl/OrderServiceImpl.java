package com.ordermanagementsystem.service.impl;

import com.ordermanagementsystem.entity.Customer;
import com.ordermanagementsystem.entity.Order;
import com.ordermanagementsystem.payload.OrderDTO;
import com.ordermanagementsystem.repository.CustomerRepo;
import com.ordermanagementsystem.repository.OrderRepo;
import com.ordermanagementsystem.service.OrderService;
import com.ordermanagementsystem.utils.Tier;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepo orderRepo;

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public List<OrderDTO> getAllOrders(Long customer_id) {
        return (orderRepo.findByCustomerId(customer_id)).stream().map(this::mapToDTO).collect(Collectors.toList());
    }


    @Override
    public OrderDTO getOrderById(Long customerId, Long orderId) {
        Customer customer = customerRepo.findById(customerId).orElseThrow(() -> new RuntimeException("customer Id not found"));
        Order order = orderRepo.findById(orderId).orElseThrow(() -> new RuntimeException("order id not found"));
        if(!order.getCustomer().getId().equals(customer.getId())) throw new RuntimeException("ID's are not matching");
        return mapToDTO(order);
    }

    @Override
    public OrderDTO createOrder(Long customerId, OrderDTO orderDto) {
        Customer customer = customerRepo.findById(customerId).orElseThrow(() -> new RuntimeException("customer Id not found"));
        Order order = mapToDAO(orderDto);
        customer.setTotal_orders(customer.getTotal_orders()+1);
        if (customer.getTotal_orders()>9 && customer.getTotal_orders()<20){
            customer.setTier(Tier.GOLD);
            customer.setDiscount(10);
        }
        if(customer.getTotal_orders()>19) {
            customer.setTier(Tier.PLATINUM);
            customer.setDiscount(20);
        }
        if (customer.getDiscount()!=0){
            Double total = (double)(order.getItem_price()* order.getQuantity());
            Double discount = ((total)*customer.getDiscount())/100;
            order.setTotal(total-discount);
        }
        else {order.setTotal((double)(order.getItem_price()* order.getQuantity()));}
        order.setCustomer(customer);

        Order orderNew = orderRepo.save(order);

        return mapToDTO(orderNew);
    }


    public OrderDTO mapToDTO(Order dao){
        OrderDTO dto = mapper.map(dao, OrderDTO.class);
        return dto;
    }

    public Order mapToDAO(OrderDTO dto){
        Order dao = mapper.map(dto, Order.class);
        return dao;
    }
}
