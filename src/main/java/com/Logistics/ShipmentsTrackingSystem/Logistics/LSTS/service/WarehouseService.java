package com.Logistics.ShipmentsTrackingSystem.Logistics.LSTS.service;

import com.Logistics.ShipmentsTrackingSystem.Logistics.LSTS.dto.Request.CreateWarehouseRequest;
import com.Logistics.ShipmentsTrackingSystem.Logistics.LSTS.entity.Warehouse;

import java.util.List;

public interface WarehouseService {

    String create(CreateWarehouseRequest createWarehouseRequest);
    Warehouse findById(Long id);
    String delete(Long id);
    List<Warehouse> findAll();

}
