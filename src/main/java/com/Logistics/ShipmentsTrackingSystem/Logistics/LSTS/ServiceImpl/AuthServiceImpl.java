package com.Logistics.ShipmentsTrackingSystem.Logistics.LSTS.ServiceImpl;

import com.Logistics.ShipmentsTrackingSystem.Logistics.LSTS.dto.Request.LoginRequest;
import com.Logistics.ShipmentsTrackingSystem.Logistics.LSTS.dto.Request.RegisterRequest;
import com.Logistics.ShipmentsTrackingSystem.Logistics.LSTS.dto.Response.AuthResponse;
import com.Logistics.ShipmentsTrackingSystem.Logistics.LSTS.entity.Users;
import com.Logistics.ShipmentsTrackingSystem.Logistics.LSTS.enums.Role;
import com.Logistics.ShipmentsTrackingSystem.Logistics.LSTS.exception.NotFoundException;
import com.Logistics.ShipmentsTrackingSystem.Logistics.LSTS.repository.UserRepository;
import com.Logistics.ShipmentsTrackingSystem.Logistics.LSTS.security.JwtFilter;
import com.Logistics.ShipmentsTrackingSystem.Logistics.LSTS.security.JwtUtil;
import com.Logistics.ShipmentsTrackingSystem.Logistics.LSTS.service.AuthService;
import lombok.Data;
import org.apache.catalina.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@Data
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;

    @Override
    public String register(RegisterRequest registerRequest) {
        Users user = new Users();

        user.setUsername(registerRequest.getUsername());
        user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));

        user.setRole(Role.WH_MANAGER);

        userRepository.save(user);
        return "Register Successfully : " + user.getUsername();
    }

    @Override
    public AuthResponse login(LoginRequest loginRequest) {
        Users users = userRepository.findByUsername(loginRequest.getUsername()).orElseThrow(() -> new NotFoundException("Username not found!"));

        boolean matches = passwordEncoder.matches(loginRequest.getPassword(), users.getPassword());
        if (!matches) {
            throw new RuntimeException("Wrong password!");
        }

        String token = jwtUtil.generateToken(users.getUsername());
        return new AuthResponse(token);


    }
}
