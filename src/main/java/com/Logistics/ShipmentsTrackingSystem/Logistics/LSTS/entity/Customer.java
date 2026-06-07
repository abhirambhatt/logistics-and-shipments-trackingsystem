package com.Logistics.ShipmentsTrackingSystem.Logistics.LSTS.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "customer")
@Data
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String customerName;
    private String email;
    private String phoneNumber;
    private String address;

    @OneToMany(mappedBy = "customer")
    @JsonManagedReference
    private List<Shipment> shipments;
}
