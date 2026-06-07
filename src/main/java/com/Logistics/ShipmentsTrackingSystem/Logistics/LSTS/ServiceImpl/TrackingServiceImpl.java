package com.Logistics.ShipmentsTrackingSystem.Logistics.LSTS.ServiceImpl;

import com.Logistics.ShipmentsTrackingSystem.Logistics.LSTS.dto.Response.TrackingResponse;
import com.Logistics.ShipmentsTrackingSystem.Logistics.LSTS.entity.Shipment;
import com.Logistics.ShipmentsTrackingSystem.Logistics.LSTS.repository.ShipmentRepository;
import com.Logistics.ShipmentsTrackingSystem.Logistics.LSTS.service.ShipmentService;
import com.Logistics.ShipmentsTrackingSystem.Logistics.LSTS.service.TrackingService;
import lombok.Data;
import org.springframework.stereotype.Service;

@Service
@Data
public class TrackingServiceImpl implements TrackingService {

    private final ShipmentRepository shipmentRepository;

    @Override
    public TrackingResponse trackShipment(String trackingNumber) {
        Shipment shipment = shipmentRepository.findByTrackingNumber(trackingNumber).orElseThrow(() -> new RuntimeException("Shipment not found"));

        TrackingResponse trackingResponse = new TrackingResponse();

        trackingResponse.setTrackingNumber(shipment.getTrackingNumber());
        trackingResponse.setShipmentStatus(shipment.getShipmentStatus());
        trackingResponse.setSourceAddress(shipment.getSourceAddress());
        trackingResponse.setDestinationAddress(shipment.getDestinationAddress());
        trackingResponse.setCreatedDate(shipment.getCreatedDate());

        return trackingResponse;
    }
}
