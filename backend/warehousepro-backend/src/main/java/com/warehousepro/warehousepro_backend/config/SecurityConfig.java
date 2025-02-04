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
     * - Permits access to public endpoints (Swagger, auth, etc.).
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
                        // Public endpoints
                        .requestMatchers(
                                "/api/auth/**",          // Authentication endpoints
                                "/swagger-ui.html",      // Swagger UI
                                "/v3/api-docs/**",       // Swagger API docs
                                "/swagger-resources/**", // Swagger resources
                                "/webjars/**",           // Swagger webjars
                                "/",                     // Home page (if applicable)
                                "/index.html",           // Home page (if applicable)
                                "/static/**",            // Static resources (CSS, JS, etc.)
                                "/favicon.ico"           // Favicon
                        ).permitAll()
                        // Secure all other endpoints
                        .anyRequest().authenticated()
                );
        return http.build();
    }
}
