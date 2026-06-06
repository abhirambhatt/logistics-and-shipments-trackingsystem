package com.Logistics.ShipmentsTrackingSystem.Logistics.LSTS.service;


import com.Logistics.ShipmentsTrackingSystem.Logistics.LSTS.entity.Users;

import java.util.List;

public interface UserService {

    List<Users> findAll();
    Users findById(Long id);

    String update(Long id, Users users);
}
