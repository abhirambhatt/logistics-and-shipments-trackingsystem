package com.Logistics.ShipmentsTrackingSystem.Logistics.LSTS.service;

import com.Logistics.ShipmentsTrackingSystem.Logistics.LSTS.dto.Request.CreateCustomerRequest;
import com.Logistics.ShipmentsTrackingSystem.Logistics.LSTS.entity.Customer;

import java.util.List;

public interface CustomerService {

    String create(CreateCustomerRequest createCustomerRequest);
    String update(Long id, CreateCustomerRequest createCustomerRequest);
    String delete(Long id);
    Customer findById(Long id);
    List<Customer> findAll();
}
