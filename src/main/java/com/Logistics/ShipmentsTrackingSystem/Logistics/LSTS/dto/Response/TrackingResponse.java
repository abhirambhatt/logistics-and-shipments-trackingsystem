package com.Logistics.ShipmentsTrackingSystem.Logistics.LSTS.dto.Response;

import com.Logistics.ShipmentsTrackingSystem.Logistics.LSTS.enums.ShipmentStatus;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class TrackingResponse {

    private String trackingNumber;
    private ShipmentStatus shipmentStatus;
    private String sourceAddress;
    private String destinationAddress;
    private LocalDateTime createdDate;
    private List<TrackingHistoryResponse> trackingHistory;


}
