package com.Logistics.ShipmentsTrackingSystem.Logistics.LSTS.controller;

import com.Logistics.ShipmentsTrackingSystem.Logistics.LSTS.entity.Users;
import com.Logistics.ShipmentsTrackingSystem.Logistics.LSTS.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@Tag(name = "User Management")
@SecurityRequirement(name = "Bearer Authentication")
@Data
public class UserController {

    private final UserService userService;

    @Operation(summary = "Retrieve user by their Id")
    @GetMapping("/{id}")
    Users findById(@PathVariable Long id) {
        return userService.findById(id);
    }

    @Operation(summary = "Retrieve all users")
    @GetMapping
    List<Users> findAll() {
        return userService.findAll();
    }

    @PatchMapping("/{id}")
    String update(@PathVariable Long id, @RequestBody Users users) {
        return userService.update(id, users);
    }
}
