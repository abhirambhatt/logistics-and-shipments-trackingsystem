package com.Logistics.ShipmentsTrackingSystem.Logistics.LSTS.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "warehouse")
@Data
public class Warehouse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String warehouseName;
    private String location;
    private String capacity;

    @ManyToMany(mappedBy = "warehouses")
    @JsonIgnoreProperties
    private List<Shipment> shipments;
}
