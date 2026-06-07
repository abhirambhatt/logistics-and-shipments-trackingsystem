package com.Logistics.ShipmentsTrackingSystem.Logistics.LSTS.dto.Response;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TrackingHistoryResponse {

    private String location;
    private String status;
    private String remarks;
    private LocalDateTime createdDate;
}
