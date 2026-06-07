package com.Logistics.ShipmentsTrackingSystem.Logistics.LSTS.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI logisticsApi() {
        return new OpenAPI()
                .info(new Info()
                        .title("Logistics & Shipment Tracking API")
                        .version("1.0")
                        .description("REST API for managing shipments, warehouses, drivers, customers and user authentication using JWT.")
                        .contact(new Contact()
                                .name("Abhirama")
                                .email("abhiram.b@icloud.com")
                                .url("https://github.com/abhirambhatt")))
                .externalDocs(new ExternalDocumentation()
                        .description("Github Repository")
                        .url("https://github.com/abhirambhatt/logitics-and-shipments-trackingsystem"));

    }
}
