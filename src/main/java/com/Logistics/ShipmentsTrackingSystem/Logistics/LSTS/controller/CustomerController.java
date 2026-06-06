package com.Logistics.ShipmentsTrackingSystem.Logistics.LSTS.controller;

import com.Logistics.ShipmentsTrackingSystem.Logistics.LSTS.dto.Request.CreateCustomerRequest;
import com.Logistics.ShipmentsTrackingSystem.Logistics.LSTS.entity.Customer;
import com.Logistics.ShipmentsTrackingSystem.Logistics.LSTS.service.CustomerService;
import jakarta.validation.Valid;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customer")
@Data
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping
    public String create(@Valid @RequestBody CreateCustomerRequest request) {
        return customerService.create(request);
    }

    @GetMapping
    public List<Customer> findAll() {
        return customerService.findAll();
    }

    @GetMapping("/{id}")
    public Customer findById(@PathVariable Long id) {
        return customerService.findById(id);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        return customerService.delete(id);
    }

    @PatchMapping("/{id}")
    public String update(@PathVariable Long id, @Valid @RequestBody CreateCustomerRequest request) {
        return customerService.update(id, request);
    }
}
