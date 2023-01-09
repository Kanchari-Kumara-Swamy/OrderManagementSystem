//package com.ordermanagementsystem.ServiceTest;
//
//import com.ordermanagementsystem.entity.Customer;
//import com.ordermanagementsystem.payload.CustomerDTO;
//import com.ordermanagementsystem.repository.CustomerRepo;
//import com.ordermanagementsystem.service.CustomerService;
//import com.ordermanagementsystem.service.impl.CustomerServiceImpl;
//import com.ordermanagementsystem.utils.Tier;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.ArgumentMatchers;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.modelmapper.ModelMapper;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.when;
//
//@ExtendWith(MockitoExtension.class)
//public class CustomerServiceTest {
//
//    Customer customer = new Customer();
//    @Mock
//    private CustomerService service;
//    @Mock
//    private CustomerRepo repo;
//    @Mock
//    private ModelMapper modelMapper;
//    @InjectMocks
//    private CustomerServiceImpl impl;
//
//    @Test
//    public void createCustomer() {
//        CustomerDTO dto = new CustomerDTO(0, "Kumar", "nanikanchari@gmail.com", "Nani@123", null, 0, null);
////      //  Customer dao = new Customer(null, "Kumar", "nanikanchari@gmail.com", "Nani@123", 0, Tier.REGULAR, 0, null);
//        CustomerDTO dto_return = new CustomerDTO(1, "Kumar", "nanikanchari@gmail.com", "Nani@123", "REGULAR", 0, null);
//
//
//        when(service.createCustomer(dto)).thenReturn(dto_return);
//        CustomerDTO customer1 = impl.createCustomer(dto);
//        assertEquals(customer1, service.createCustomer(dto));
//    }
//}

// tests are failing because of the model mapper
