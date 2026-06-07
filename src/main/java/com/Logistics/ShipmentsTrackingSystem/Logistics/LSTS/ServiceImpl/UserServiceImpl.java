package com.Logistics.ShipmentsTrackingSystem.Logistics.LSTS.ServiceImpl;

import com.Logistics.ShipmentsTrackingSystem.Logistics.LSTS.entity.Users;
import com.Logistics.ShipmentsTrackingSystem.Logistics.LSTS.exception.NotFoundException;
import com.Logistics.ShipmentsTrackingSystem.Logistics.LSTS.repository.UserRepository;
import com.Logistics.ShipmentsTrackingSystem.Logistics.LSTS.service.UserService;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public List<Users> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Users findById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new NotFoundException("User not found"));
    }

    @Override
    public String update(Long id, Users users){
        Users ExistingUser = userRepository.findById(id).orElseThrow(() -> new NotFoundException("User not found"));

        if (ExistingUser == null){
            throw new NotFoundException("User not found");
        }

        if (users.getUsername() != null){
            ExistingUser.setUsername(users.getUsername());
        }

        if (users.getPassword() != null){
            ExistingUser.setPassword(users.getPassword());
        }

        if (users.getRole() != null){
            ExistingUser.setRole(users.getRole());
        }

        userRepository.save(ExistingUser);
        return "User updated successfully ; " + ExistingUser.getUsername();
    }
}
