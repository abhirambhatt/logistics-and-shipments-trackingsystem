package com.Logistics.ShipmentsTrackingSystem.Logistics.LSTS.dto.Request;

import lombok.Data;

@Data
public class CreateDriverRequest {

    private String driverName;
    private String phoneNumber;
    private String licenseNumber;
    private String vehicleNumber;
}
