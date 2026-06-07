package com.Logistics.ShipmentsTrackingSystem.Logistics.LSTS.repository;

import com.Logistics.ShipmentsTrackingSystem.Logistics.LSTS.entity.TrackingHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrackingHistoryRepository extends JpaRepository<TrackingHistory, Long> {
}
