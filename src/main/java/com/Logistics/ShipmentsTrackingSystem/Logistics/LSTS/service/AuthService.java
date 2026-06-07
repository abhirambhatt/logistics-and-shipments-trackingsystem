package com.Logistics.ShipmentsTrackingSystem.Logistics.LSTS.service;


import com.Logistics.ShipmentsTrackingSystem.Logistics.LSTS.dto.Request.LoginRequest;
import com.Logistics.ShipmentsTrackingSystem.Logistics.LSTS.dto.Request.RegisterRequest;
import com.Logistics.ShipmentsTrackingSystem.Logistics.LSTS.dto.Response.AuthResponse;

public interface AuthService {

    String register(RegisterRequest registerRequest);
    AuthResponse login(LoginRequest loginRequest);

}
