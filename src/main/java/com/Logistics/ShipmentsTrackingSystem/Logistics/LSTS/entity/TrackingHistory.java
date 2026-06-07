package com.Logistics.ShipmentsTrackingSystem.Logistics.LSTS.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "trackingHistory")
@Data
public class TrackingHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String location;
    private String status;
    private String remarks;
    private LocalDateTime updatedDate;

    @ManyToOne
    @JoinColumn(name = "shipmentId")
    @JsonBackReference
    private Shipment shipment;
}
