package com.Logistics.ShipmentsTrackingSystem.Logistics.LSTS.controller;

import com.Logistics.ShipmentsTrackingSystem.Logistics.LSTS.dto.Request.CreateDriverRequest;
import com.Logistics.ShipmentsTrackingSystem.Logistics.LSTS.entity.Driver;
import com.Logistics.ShipmentsTrackingSystem.Logistics.LSTS.service.DriverService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/driver")
@Tag(name = "Driver Management")
@SecurityRequirement(name = "Bearer Authentication")
@Data
public class DriverController {

    private final DriverService driverService;

    @Operation(summary = "Create a driver")
    @PostMapping
    public String create(@Valid @RequestBody CreateDriverRequest request) {
        return driverService.create(request);
    }

    @Operation(summary = "Retrieve all drivers")
    @GetMapping
    public List<Driver> getDrivers() {
        return driverService.findAll();
    }

    @Operation(summary = "Update driver by their Id")
    @PatchMapping("/{id}")
    public String update(@PathVariable Long id, @Valid @RequestBody CreateDriverRequest request) {
        return driverService.update(id, request);
    }

    @Operation(summary = "Retrieve driver by their Id")
    @GetMapping("/{id}")
    public Driver getDriver(@PathVariable Long id) {
        return driverService.findById(id);
    }

    @Operation(summary = "Delete customer by their Id")
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        return driverService.delete(id);
    }
}
