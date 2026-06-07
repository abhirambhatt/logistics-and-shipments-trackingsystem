package com.Logistics.ShipmentsTrackingSystem.Logistics.LSTS.dto.Request;

import com.Logistics.ShipmentsTrackingSystem.Logistics.LSTS.enums.ShipmentStatus;
import lombok.Data;

@Data
public class UpdateShipmentStatusRequest {

    private ShipmentStatus shipmentStatus;
    private String location;
    private String remarks;
}
