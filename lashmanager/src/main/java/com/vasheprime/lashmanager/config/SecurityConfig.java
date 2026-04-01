package com.vasheprime.lashmanager.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                // Разрешаем доступ ко всем страницам без авторизации
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().permitAll()
                )
                // ВКЛЮЧАЕМ CSRF защиту (это важно!)
                .csrf(csrf -> {
                    try {
                        csrf.init(http);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                });

        return http.build();
    }
}
