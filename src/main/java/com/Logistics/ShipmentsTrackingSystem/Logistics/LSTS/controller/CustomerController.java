package com.Logistics.ShipmentsTrackingSystem.Logistics.LSTS.controller;

import com.Logistics.ShipmentsTrackingSystem.Logistics.LSTS.dto.Request.CreateCustomerRequest;
import com.Logistics.ShipmentsTrackingSystem.Logistics.LSTS.entity.Customer;
import com.Logistics.ShipmentsTrackingSystem.Logistics.LSTS.service.CustomerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customer")
@Tag(name = "Customer Management")
@SecurityRequirement(name = "Bearer Authentication")
@Data
public class CustomerController {

    private final CustomerService customerService;

    @Operation(summary = "Create a customer")
    @PostMapping
    public String create(@Valid @RequestBody CreateCustomerRequest request) {
        return customerService.create(request);
    }

    @Operation(summary = "Retrieve all customers")
    @GetMapping
    public List<Customer> findAll() {
        return customerService.findAll();
    }

    @Operation(summary = "Retrieve customers by their Id")
    @GetMapping("/{id}")
    public Customer findById(@PathVariable Long id) {
        return customerService.findById(id);
    }

    @Operation(summary = "Delete customer by their Id")
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        return customerService.delete(id);
    }

    @Operation(summary = "Update customer detail by their Id")
    @PatchMapping("/{id}")
    public String update(@PathVariable Long id, @Valid @RequestBody CreateCustomerRequest request) {
        return customerService.update(id, request);
    }
}
