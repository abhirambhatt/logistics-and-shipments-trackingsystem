package com.Logistics.ShipmentsTrackingSystem.Logistics.LSTS.dto.Request;

import lombok.Data;

@Data
public class CreateWarehouseRequest {

    private String warehouseName;
    private String location;
    private String capacity;
}
