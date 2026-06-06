package com.Logistics.ShipmentsTrackingSystem.Logistics.LSTS.controller;

import com.Logistics.ShipmentsTrackingSystem.Logistics.LSTS.dto.Request.CreateDriverRequest;
import com.Logistics.ShipmentsTrackingSystem.Logistics.LSTS.entity.Driver;
import com.Logistics.ShipmentsTrackingSystem.Logistics.LSTS.service.DriverService;
import jakarta.validation.Valid;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/driver")
@Data
public class DriverController {

    private final DriverService driverService;

    @PostMapping
    public String create(@Valid @RequestBody CreateDriverRequest request) {
        return driverService.create(request);
    }

    @GetMapping
    public List<Driver> getDrivers() {
        return driverService.findAll();
    }

    @PatchMapping("/{id}")
    public String update(@PathVariable Long id, @Valid @RequestBody CreateDriverRequest request) {
        return driverService.update(id, request);
    }

    @GetMapping("/{id}")
    public Driver getDriver(@PathVariable Long id) {
        return driverService.findById(id);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        return driverService.delete(id);
    }
}
