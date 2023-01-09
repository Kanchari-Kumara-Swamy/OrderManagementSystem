package com.ordermanagementsystem.service.impl;

import com.ordermanagementsystem.entity.Customer;
import com.ordermanagementsystem.payload.CustomerDTO;
import com.ordermanagementsystem.repository.CustomerRepo;
import com.ordermanagementsystem.service.CustomerService;
import com.ordermanagementsystem.utils.Tier;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public List<CustomerDTO> getAllCustomers() {
        return customerRepo.findAll().stream().map(this::maptoDTO).collect(Collectors.toList());
    }

    @Override
    public CustomerDTO getCustomer(Long id) {
        return maptoDTO(customerRepo.findById(id).orElseThrow(RuntimeException::new));
    }

    @Override
    public CustomerDTO createCustomer(CustomerDTO customerDTO) {
        Customer customer = maptoDAO(customerDTO);
        customer.setTier(Tier.REGULAR);
        Customer customerNew = customerRepo.save(customer);
        return maptoDTO(customerNew);
    }
    
    public Customer maptoDAO(CustomerDTO dto){
        return mapper.map(dto, Customer.class);
    }

    public CustomerDTO maptoDTO(Customer dao){
        return mapper.map(dao, CustomerDTO.class);
    }
}
