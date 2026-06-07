package com.Logistics.ShipmentsTrackingSystem.Logistics.LSTS.service;

import com.Logistics.ShipmentsTrackingSystem.Logistics.LSTS.dto.Request.CreateDriverRequest;
import com.Logistics.ShipmentsTrackingSystem.Logistics.LSTS.entity.Driver;

import java.util.List;

public interface DriverService {

    String create(CreateDriverRequest createDriverRequest);
    String update(Long id, CreateDriverRequest createDriverRequest);
    String delete(Long id);
    List<Driver> findAll();
    Driver findById(Long id);
}
