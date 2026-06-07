package com.Logistics.ShipmentsTrackingSystem.Logistics.LSTS.dto.Request;

import lombok.Data;

@Data
public class CreateCustomerRequest {

    private String customerName;
    private String email;
    private String phoneNumber;
    private String address;
}
