package com.Logistics.ShipmentsTrackingSystem.Logistics.LSTS.controller;

import com.Logistics.ShipmentsTrackingSystem.Logistics.LSTS.dto.Request.CreateWarehouseRequest;
import com.Logistics.ShipmentsTrackingSystem.Logistics.LSTS.entity.Warehouse;
import com.Logistics.ShipmentsTrackingSystem.Logistics.LSTS.service.WarehouseService;
import jakarta.validation.Valid;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/warehouse")
@Data
public class WarhouseController {

    private final WarehouseService warehouseService;

    @PostMapping
    public String create(@Valid @RequestBody CreateWarehouseRequest request) {
        return warehouseService.create(request);
    }

    @GetMapping
    public List<Warehouse> findAll() {
        return warehouseService.findAll();
    }

    @GetMapping("/{id}")
    public Warehouse findById(@PathVariable Long id) {
        return warehouseService.findById(id);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        return warehouseService.delete(id);
    }
}
