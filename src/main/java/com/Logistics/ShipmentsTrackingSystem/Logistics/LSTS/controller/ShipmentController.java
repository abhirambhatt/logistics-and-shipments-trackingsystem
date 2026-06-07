package com.Logistics.ShipmentsTrackingSystem.Logistics.LSTS.controller;

import com.Logistics.ShipmentsTrackingSystem.Logistics.LSTS.dto.Request.CreateShipmentRequest;
import com.Logistics.ShipmentsTrackingSystem.Logistics.LSTS.dto.Request.UpdateShipmentStatusRequest;
import com.Logistics.ShipmentsTrackingSystem.Logistics.LSTS.entity.Shipment;
import com.Logistics.ShipmentsTrackingSystem.Logistics.LSTS.service.ShipmentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/shipment")
@Tag(name = "Shipment Management")
@SecurityRequirement(name = "Bearer Authentication")
@Data
public class ShipmentController {

    private final ShipmentService shipmentService;

    @Operation(summary = "Create a shipment")
    @PostMapping
    public String create(@Valid @RequestBody CreateShipmentRequest request) {
        return shipmentService.create(request);
    }

    @Operation(summary = "Retrieve all shipments")
    @GetMapping
    public List<Shipment> finshAll() {
        return shipmentService.findAll();
    }

    @Operation(summary = "Retrieve shipments by their Id")
    @GetMapping("/{id}")
    public Shipment finshById(@PathVariable Long id) {
        return shipmentService.findById(id);
    }

    @Operation(summary = "Update a shipment by Id")
    @PatchMapping("/{id}/status")
    public String updateStatus(@PathVariable Long id, @Valid @RequestBody UpdateShipmentStatusRequest request) {
        return shipmentService.updateStatus(id, request);
    }


}
