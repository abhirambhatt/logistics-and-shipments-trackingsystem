package com.Logistics.ShipmentsTrackingSystem.Logistics.LSTS.ServiceImpl;

import com.Logistics.ShipmentsTrackingSystem.Logistics.LSTS.dto.Request.CreateDriverRequest;
import com.Logistics.ShipmentsTrackingSystem.Logistics.LSTS.entity.Driver;
import com.Logistics.ShipmentsTrackingSystem.Logistics.LSTS.repository.DriverRepository;
import com.Logistics.ShipmentsTrackingSystem.Logistics.LSTS.service.DriverService;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Data
public class DriverServiceImpl implements DriverService {

    private final DriverRepository driverRepository;

    @Override
    public String create(CreateDriverRequest createDriverRequest) {
        Driver driver = new Driver();

        driver.setDriverName(createDriverRequest.getDriverName());
        driver.setPhoneNumber(String.valueOf(createDriverRequest.getPhoneNumber()));
        driver.setLicenseNumber(String.valueOf(createDriverRequest.getLicenseNumber()));
        driver.setVehicleNumber(String.valueOf(createDriverRequest.getVehicleNumber()));

        driverRepository.save(driver);
        return "Driver created : " + driver.getDriverName();
    }

    @Override
    public String update(Long id, CreateDriverRequest createDriverRequest) {
        Driver driver = driverRepository.findById(id).orElseThrow(() -> new RuntimeException("Driver Not Found"));

        driver.setDriverName(createDriverRequest.getDriverName());
        driver.setPhoneNumber(String.valueOf(createDriverRequest.getPhoneNumber()));
        driver.setLicenseNumber(String.valueOf(createDriverRequest.getLicenseNumber()));
        driver.setVehicleNumber(String.valueOf(createDriverRequest.getVehicleNumber()));
        driverRepository.save(driver);
        return "Driver Updated : " + driver.getDriverName();
    }

    @Override
    public String delete(Long id) {
        driverRepository.deleteById(id);
        return "Driver deleted : " + id;
    }

    @Override
    public List<Driver> findAll() {
        return driverRepository.findAll();
    }

    @Override
    public Driver findById(Long id) {
        return driverRepository.findById(id).get();
    }
}
