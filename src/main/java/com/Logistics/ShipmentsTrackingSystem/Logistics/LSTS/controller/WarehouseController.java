package com.Logistics.ShipmentsTrackingSystem.Logistics.LSTS.controller;

import com.Logistics.ShipmentsTrackingSystem.Logistics.LSTS.dto.Request.CreateWarehouseRequest;
import com.Logistics.ShipmentsTrackingSystem.Logistics.LSTS.entity.Warehouse;
import com.Logistics.ShipmentsTrackingSystem.Logistics.LSTS.service.WarehouseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/warehouse")
@Tag(name = "Warehouse Management")
@SecurityRequirement(name = "Bearer Authentication")
@Data
public class WarehouseController {

    private final WarehouseService warehouseService;

    @Operation(summary = "Create a warehouse")
    @PostMapping
    public String create(@Valid @RequestBody CreateWarehouseRequest request) {
        return warehouseService.create(request);
    }

    @Operation(summary = "Retrieve all warehouse")
    @GetMapping
    public List<Warehouse> findAll() {
        return warehouseService.findAll();
    }

    @Operation(summary = "Retrieve warehouse by Id")
    @GetMapping("/{id}")
    public Warehouse findById(@PathVariable Long id) {
        return warehouseService.findById(id);
    }

    @Operation(summary = "Delete a warehouse by Id")
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        return warehouseService.delete(id);
    }
}
