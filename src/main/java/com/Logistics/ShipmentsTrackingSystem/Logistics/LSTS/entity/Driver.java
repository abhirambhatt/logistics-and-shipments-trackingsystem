package com.Logistics.ShipmentsTrackingSystem.Logistics.LSTS.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "driver")
@Data
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String driverName;
    private String phoneNumber;
    private String licenseNumber;
    private String vehicleNumber;

    @OneToMany(mappedBy = "driver")
    @JsonManagedReference
    private List<Shipment> shipments;
}
