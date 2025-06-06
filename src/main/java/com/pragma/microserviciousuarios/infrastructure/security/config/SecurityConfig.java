package com.pragma.microserviciousuarios.infrastructure.security.config;

import com.pragma.microserviciousuarios.infrastructure.adapter.persistence.JwtProviderAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/admin/**").hasRole("ADMIN")
                        .requestMatchers("/seller/**").hasRole("SELLER")
                        .requestMatchers("/client/**").hasRole("CLIENT")
                        .anyRequest().authenticated())
                .formLogin(form -> form.permitAll());
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public JwtProviderAdapter jwtProviderAdapter() {
        return new JwtProviderAdapter();
    }
}
