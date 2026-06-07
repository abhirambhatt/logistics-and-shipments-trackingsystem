package com.Logistics.ShipmentsTrackingSystem.Logistics.LSTS.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String home() {
        return """
        <!DOCTYPE html>
        <html>
        <head>
            <title>Logistics API</title>
            <style>
                body{
                    font-family:Arial,sans-serif;
                    text-align:center;
                    margin-top:100px;
                    background:#f5f5f5;
                }
                a{
                    display:inline-block;
                    padding:12px 24px;
                    background:#28a745;
                    color:white;
                    text-decoration:none;
                    border-radius:6px;
                    font-size:18px;
                }
            </style>
        </head>
        <body>
            <h1>Logistics & Shipment Tracking API</h1>
            <p>REST API built with Spring Boot, JWT, MySQL and AWS.</p>

            <a href="/swagger-ui/index.html">
                View Swagger Documentation
            </a>
        </body>
        </html>
        """;
    }
}
