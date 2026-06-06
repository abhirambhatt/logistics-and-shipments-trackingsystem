package com.Logistics.ShipmentsTrackingSystem.Logistics.LSTS.service;

import com.Logistics.ShipmentsTrackingSystem.Logistics.LSTS.dto.Request.CreateShipmentRequest;
import com.Logistics.ShipmentsTrackingSystem.Logistics.LSTS.dto.Request.UpdateShipmentStatusRequest;
import com.Logistics.ShipmentsTrackingSystem.Logistics.LSTS.entity.Shipment;

import java.util.List;

public interface ShipmentService {

    String create(CreateShipmentRequest createShipmentRequest);

    List<Shipment> findAll();

    Shipment findById(Long id);

    String updateStatus(Long shipmentId, UpdateShipmentStatusRequest updateShipmentStatusRequest);
}
