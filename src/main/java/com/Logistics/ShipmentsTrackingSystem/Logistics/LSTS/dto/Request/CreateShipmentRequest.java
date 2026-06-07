package com.Logistics.ShipmentsTrackingSystem.Logistics.LSTS.dto.Request;

import lombok.Data;

@Data
public class CreateShipmentRequest {

    private Long customerId;
    private Long driverId;
    private Double weight;
    private String description;
    private String sourceAddress;
    private String destinationAddress;
}
