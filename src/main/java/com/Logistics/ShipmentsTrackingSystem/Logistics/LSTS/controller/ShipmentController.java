package com.Logistics.ShipmentsTrackingSystem.Logistics.LSTS.controller;

import com.Logistics.ShipmentsTrackingSystem.Logistics.LSTS.dto.Request.CreateShipmentRequest;
import com.Logistics.ShipmentsTrackingSystem.Logistics.LSTS.dto.Request.UpdateShipmentStatusRequest;
import com.Logistics.ShipmentsTrackingSystem.Logistics.LSTS.entity.Shipment;
import com.Logistics.ShipmentsTrackingSystem.Logistics.LSTS.service.ShipmentService;
import jakarta.validation.Valid;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/shipment")
@Data
public class ShipmentController {

    private final ShipmentService shipmentService;

    @PostMapping
    public String create(@Valid @RequestBody CreateShipmentRequest request) {
        return shipmentService.create(request);
    }

    @GetMapping
    public List<Shipment> finshAll() {
        return shipmentService.findAll();
    }

    @GetMapping("/{id}")
    public Shipment finshById(@PathVariable Long id) {
        return shipmentService.findById(id);
    }

    @PatchMapping("/{id}/status")
    public String updateStatus(@PathVariable Long id, @Valid @RequestBody UpdateShipmentStatusRequest request) {
        return shipmentService.updateStatus(id, request);
    }
}
