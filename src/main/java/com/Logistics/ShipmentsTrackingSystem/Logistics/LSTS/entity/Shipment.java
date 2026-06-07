package com.Logistics.ShipmentsTrackingSystem.Logistics.LSTS.entity;

import com.Logistics.ShipmentsTrackingSystem.Logistics.LSTS.enums.ShipmentStatus;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "shipment")
@Data
public class Shipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String trackingNumber;
    private Double weight;
    private String description;

    @Enumerated(EnumType.STRING)
    private ShipmentStatus shipmentStatus;

    private String sourceAddress;
    private String destinationAddress;
    private LocalDateTime createdDate;

    @ManyToOne
    @JoinColumn(name = "customerId")
    @JsonBackReference
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "driverId")
    @JsonBackReference
    private Driver driver;

    @OneToMany(mappedBy = "shipment")
    @JsonManagedReference
    private List<TrackingHistory> trackingHistory;

    @ManyToMany
    @JoinTable(
            name = "shipment_warehouse",
    joinColumns = @JoinColumn(name = "shipment_id"),
    inverseJoinColumns = @JoinColumn(name = "warehouse_id")
    )
    @JsonIgnoreProperties
    private List<Warehouse> warehouses;


}
