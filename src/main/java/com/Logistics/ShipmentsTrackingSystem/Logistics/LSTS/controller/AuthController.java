package com.Logistics.ShipmentsTrackingSystem.Logistics.LSTS.controller;

import com.Logistics.ShipmentsTrackingSystem.Logistics.LSTS.dto.Request.LoginRequest;
import com.Logistics.ShipmentsTrackingSystem.Logistics.LSTS.dto.Request.RegisterRequest;
import com.Logistics.ShipmentsTrackingSystem.Logistics.LSTS.dto.Response.AuthResponse;
import com.Logistics.ShipmentsTrackingSystem.Logistics.LSTS.service.AuthService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.Data;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@Data
public class AuthController {

    private final AuthService authService;

    @Operation(summary = "Register for Authentication")
    @PostMapping("/register")
    public String register(@RequestBody RegisterRequest registerRequest) {
        return authService.register(registerRequest);
    }

    @Operation(summary = "Login for Authentication")
    @PostMapping("/login")
    public AuthResponse login(@RequestBody LoginRequest loginRequest) {
        return authService.login(loginRequest);
    }
}
