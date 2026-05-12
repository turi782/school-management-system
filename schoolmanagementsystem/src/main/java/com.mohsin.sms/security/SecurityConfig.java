package com.mohsin.sms.security;

import org.springframework.context.annotation.*;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;



@Configuration
public class SecurityConfig {

    private final JwtFilter jwtFilter;

    public SecurityConfig(JwtFilter jwtFilter) {
        this.jwtFilter = jwtFilter;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/auth/**").permitAll()

                        // ADMIN ONLY
                        .requestMatchers("/api/teachers/**").hasRole("ADMIN")

                        // ADMIN + TEACHER
                        .requestMatchers("/api/courses/**")
                        .hasAnyRole("ADMIN", "TEACHER")

                        // ALL AUTHENTICATED USERS
                        .requestMatchers("/api/students/**")
                        .authenticated()

                        .requestMatchers("/api/attendance/**")
                        .hasAnyRole("ADMIN", "TEACHER")

                        .anyRequest().authenticated()

                )
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);


        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
