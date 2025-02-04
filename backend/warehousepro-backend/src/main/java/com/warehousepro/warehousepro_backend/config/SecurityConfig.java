package com.warehousepro.warehousepro_backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Configuration class for Spring Security.
 * Defines security rules and JWT authentication setup.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    /**
     * Configures the security filter chain.
     * - Disables CSRF protection.
     * - Permits access to /api/auth/** without authentication.
     * - Secures all other endpoints.
     *
     * @param http HttpSecurity object to configure.
     * @return SecurityFilterChain instance.
     * @throws Exception if configuration fails.
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // Disable CSRF protection
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/auth/**").permitAll() // Allow access to /api/auth/**
                        .anyRequest().authenticated() // Secure all other endpoints
                );
        return http.build();
    }
}
