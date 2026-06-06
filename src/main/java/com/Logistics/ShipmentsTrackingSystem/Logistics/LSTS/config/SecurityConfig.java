package com.Logistics.ShipmentsTrackingSystem.Logistics.LSTS.config;

import com.Logistics.ShipmentsTrackingSystem.Logistics.LSTS.repository.UserRepository;
import com.Logistics.ShipmentsTrackingSystem.Logistics.LSTS.security.JwtFilter;
import lombok.Data;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@Data
public class SecurityConfig {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtFilter jwtFilter;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/users/**").hasRole("ADMIN")
                        .requestMatchers("/api/auth/**").permitAll()
                        .requestMatchers("/api/customer/**").hasRole("MANAGER")
                        .requestMatchers("/api/driver/**").hasAnyRole("MANAGER", "USER")
                        .requestMatchers("/api/shipment/**").hasRole("MANAGER")
                        .requestMatchers("/api/warehouse/**").hasAnyRole("MANAGER", "USER")
                        .anyRequest().authenticated()
                )
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
                .build();

    }

}
