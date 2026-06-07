package com.Logistics.ShipmentsTrackingSystem.Logistics.LSTS.ServiceImpl;

import com.Logistics.ShipmentsTrackingSystem.Logistics.LSTS.dto.Request.CreateShipmentRequest;
import com.Logistics.ShipmentsTrackingSystem.Logistics.LSTS.dto.Request.UpdateShipmentStatusRequest;
import com.Logistics.ShipmentsTrackingSystem.Logistics.LSTS.entity.*;
import com.Logistics.ShipmentsTrackingSystem.Logistics.LSTS.enums.ShipmentStatus;
import com.Logistics.ShipmentsTrackingSystem.Logistics.LSTS.repository.*;
import com.Logistics.ShipmentsTrackingSystem.Logistics.LSTS.service.ShipmentService;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;


@Service
@Data
public class ShipmentServiceImpl implements ShipmentService {

    private final ShipmentRepository shipmentRepository;
    private final CustomerRepository customerRepository;
    private final DriverRepository driverRepository;
    private final TrackingHistoryRepository trackingHistoryRepository;

    @Override
    public String create(CreateShipmentRequest createShipmentRequest) {
        Customer customer = customerRepository.findById(createShipmentRequest.getCustomerId()).orElseThrow(() -> new RuntimeException("Customer Not Found"));

        Driver driver = driverRepository.findById(createShipmentRequest.getDriverId()).orElseThrow(() -> new RuntimeException("Driver Not Found"));


        Shipment shipment = new Shipment();
        shipment.setCustomer(customer);
        shipment.setDriver(driver);
        shipment.setWeight(createShipmentRequest.getWeight());
        shipment.setDescription(createShipmentRequest.getDescription());
        shipment.setSourceAddress(createShipmentRequest.getSourceAddress());
        shipment.setDestinationAddress(createShipmentRequest.getDestinationAddress());
        shipment.setTrackingNumber("TRK-" + System.currentTimeMillis());

        shipment.setShipmentStatus(ShipmentStatus.PENDING);
        shipment.setCreatedDate(LocalDateTime.now());

        shipmentRepository.save(shipment);
        return "Shipment Created Successfully for : " + shipment.getTrackingNumber();
    }


    @Override
    public List<Shipment> findAll() {
        return shipmentRepository.findAll();
    }

    @Override
    public Shipment findById(Long id) {
        return shipmentRepository.findById(id).get();
    }

    @Override
    public String updateStatus(Long shipmentId, UpdateShipmentStatusRequest updateShipmentStatusRequest) {
        Shipment shipment = findById(shipmentId);

        shipment.setShipmentStatus(updateShipmentStatusRequest.getShipmentStatus());

        TrackingHistory trackingHistory = new TrackingHistory();
        trackingHistory.setShipment(shipment);
        trackingHistory.setLocation(updateShipmentStatusRequest.getLocation());
        trackingHistory.setStatus(updateShipmentStatusRequest.getShipmentStatus().name());
        trackingHistory.setUpdatedDate(LocalDateTime.now());

        shipmentRepository.save(shipment);
        trackingHistoryRepository.save(trackingHistory);
        return "Shipment Updated Successfully for : " + shipment.getTrackingNumber();

    }




}
