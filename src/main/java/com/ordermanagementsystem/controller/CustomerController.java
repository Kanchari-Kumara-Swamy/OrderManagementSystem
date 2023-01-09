package com.ordermanagementsystem.controller;

import com.ordermanagementsystem.payload.CustomerDTO;
import com.ordermanagementsystem.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/getcustomer/{customerId}")
    public CustomerDTO getCustomer(@PathVariable Long id){
        return customerService.getCustomer(id);
    }

    @GetMapping("/getallcustomers")
    public List<CustomerDTO> getAllCustomers(){
        return customerService.getAllCustomers();
    }

    @PostMapping("/createcustomer")
    public ResponseEntity<CustomerDTO> createCustomer(@RequestBody CustomerDTO customer) {
        return new ResponseEntity<>(customerService.createCustomer(customer), HttpStatus.CREATED);
    }
}
