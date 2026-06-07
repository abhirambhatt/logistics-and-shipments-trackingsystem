package com.Logistics.ShipmentsTrackingSystem.Logistics.LSTS.service;

import com.Logistics.ShipmentsTrackingSystem.Logistics.LSTS.dto.Response.TrackingResponse;

public interface TrackingService {

    TrackingResponse trackShipment(String trackingNumber);
}
