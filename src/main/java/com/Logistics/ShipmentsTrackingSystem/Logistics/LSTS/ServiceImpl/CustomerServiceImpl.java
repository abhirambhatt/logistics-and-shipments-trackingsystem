package com.Logistics.ShipmentsTrackingSystem.Logistics.LSTS.ServiceImpl;

import com.Logistics.ShipmentsTrackingSystem.Logistics.LSTS.dto.Request.CreateCustomerRequest;
import com.Logistics.ShipmentsTrackingSystem.Logistics.LSTS.entity.Customer;
import com.Logistics.ShipmentsTrackingSystem.Logistics.LSTS.exception.NotFoundException;
import com.Logistics.ShipmentsTrackingSystem.Logistics.LSTS.repository.CustomerRepository;
import com.Logistics.ShipmentsTrackingSystem.Logistics.LSTS.service.CustomerService;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Data
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Override
    public String create(CreateCustomerRequest createCustomerRequest) {

        Customer customer = new Customer();

        customer.setCustomerName(createCustomerRequest.getCustomerName());
        customer.setEmail(createCustomerRequest.getEmail());
        customer.setPhoneNumber(createCustomerRequest.getPhoneNumber());
        customer.setAddress(createCustomerRequest.getAddress());

        customerRepository.save(customer);
        return "Customer Created : " + customer.getCustomerName();
    }

    @Override
    public String update(Long id, CreateCustomerRequest createCustomerRequest) {
        Customer customer = customerRepository.findById(id).orElseThrow(() -> new NotFoundException("Customer Not Found"));

        customer.setCustomerName(createCustomerRequest.getCustomerName());
        customer.setEmail(createCustomerRequest.getEmail());
        customer.setPhoneNumber(createCustomerRequest.getPhoneNumber());
        customer.setAddress(createCustomerRequest.getAddress());
        customerRepository.save(customer);
        return "Customer Updated : " + customer.getCustomerName();
    }

    @Override
    public String delete(Long id) {
        customerRepository.deleteById(id);
        return "Customer Deleted : " + id;
    }

    @Override
    public Customer findById(Long id) {
        return customerRepository.findById(id).get();
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }
}
