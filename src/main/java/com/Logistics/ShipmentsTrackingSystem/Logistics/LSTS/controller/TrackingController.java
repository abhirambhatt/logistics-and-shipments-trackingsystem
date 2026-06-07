package com.Logistics.ShipmentsTrackingSystem.Logistics.LSTS.controller;

import com.Logistics.ShipmentsTrackingSystem.Logistics.LSTS.dto.Response.TrackingResponse;
import com.Logistics.ShipmentsTrackingSystem.Logistics.LSTS.service.TrackingService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tracking")
@Data
public class TrackingController {

    private final TrackingService trackingService;

    @Operation(summary = "Track a shipment by Tracking number")
    @GetMapping("/{trackingNumber}")
    public ResponseEntity<TrackingResponse> trackShipment(@PathVariable String trackingNumber) {
        return ResponseEntity.ok(trackingService.trackShipment(trackingNumber));
        }
}
