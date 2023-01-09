package com.ordermanagementsystem.service;

import com.ordermanagementsystem.payload.CustomerDTO;

import java.util.List;

public interface CustomerService {

    List<CustomerDTO> getAllCustomers();

    CustomerDTO getCustomer(Long id);

    CustomerDTO createCustomer(CustomerDTO customer);
}
