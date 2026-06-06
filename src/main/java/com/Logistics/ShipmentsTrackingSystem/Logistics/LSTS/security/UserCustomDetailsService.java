package com.Logistics.ShipmentsTrackingSystem.Logistics.LSTS.security;

import com.Logistics.ShipmentsTrackingSystem.Logistics.LSTS.entity.Users;
import com.Logistics.ShipmentsTrackingSystem.Logistics.LSTS.repository.UserRepository;
import lombok.Data;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
public class UserCustomDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users users = userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User not found"));

        return new User(users.getUsername(), users.getPassword(), List.of(new SimpleGrantedAuthority("ROLE_" + users.getRole().name())));
    }
}
