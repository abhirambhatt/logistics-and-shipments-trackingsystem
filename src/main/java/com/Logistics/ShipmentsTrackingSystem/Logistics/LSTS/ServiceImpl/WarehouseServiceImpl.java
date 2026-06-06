package com.Logistics.ShipmentsTrackingSystem.Logistics.LSTS.ServiceImpl;

import com.Logistics.ShipmentsTrackingSystem.Logistics.LSTS.dto.Request.CreateWarehouseRequest;
import com.Logistics.ShipmentsTrackingSystem.Logistics.LSTS.entity.Warehouse;
import com.Logistics.ShipmentsTrackingSystem.Logistics.LSTS.exception.NotFoundException;
import com.Logistics.ShipmentsTrackingSystem.Logistics.LSTS.repository.WarehouseRepository;
import com.Logistics.ShipmentsTrackingSystem.Logistics.LSTS.service.WarehouseService;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
public class WarehouseServiceImpl implements WarehouseService {

    private final WarehouseRepository warehouseRepository;

    @Override
    public String create(CreateWarehouseRequest createWarehouseRequest) {
        Warehouse warehouse = new Warehouse();

        warehouse.setWarehouseName(createWarehouseRequest.getWarehouseName());
        warehouse.setCapacity(createWarehouseRequest.getCapacity());
        warehouse.setLocation(createWarehouseRequest.getLocation());

        warehouseRepository.save(warehouse);
        return "Warehouse created";
    }

    @Override
    public Warehouse findById(Long id) {
        return warehouseRepository.findById(id).orElseThrow(() -> new NotFoundException("Warehouse not found"));
    }

    @Override
    public String delete(Long id) {
        warehouseRepository.deleteById(id);
        return "Warehouse deleted : " + id;
    }

    @Override
    public List<Warehouse> findAll() {
        return warehouseRepository.findAll();
    }
}
