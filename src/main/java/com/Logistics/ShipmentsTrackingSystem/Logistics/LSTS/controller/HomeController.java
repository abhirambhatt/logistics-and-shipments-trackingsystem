package com.Logistics.ShipmentsTrackingSystem.Logistics.LSTS.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "Logistics & Shipment Tracking API is running successfully";
    }
}
