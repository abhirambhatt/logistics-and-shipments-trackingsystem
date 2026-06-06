package com.Logistics.ShipmentsTrackingSystem.Logistics.LSTS.controller;

import com.Logistics.ShipmentsTrackingSystem.Logistics.LSTS.entity.Users;
import com.Logistics.ShipmentsTrackingSystem.Logistics.LSTS.service.UserService;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@Data
public class UserController {

    private final UserService userService;

    @GetMapping("/{id}")
    Users findById(@PathVariable Long id) {
        return userService.findById(id);
    }
    @GetMapping
    List<Users> findAll() {
        return userService.findAll();
    }

    @PatchMapping("/{id}")
    String update(@PathVariable Long id, @RequestBody Users users) {
        return userService.update(id, users);
    }
}
