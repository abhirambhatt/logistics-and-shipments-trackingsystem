package com.Logistics.ShipmentsTrackingSystem.Logistics.LSTS.repository;

import com.Logistics.ShipmentsTrackingSystem.Logistics.LSTS.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
