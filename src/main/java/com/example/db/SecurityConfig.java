package com.example.db;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.ArrayList;
import java.util.List;


@Configuration
@EnableWebSecurity
public class SecurityConfig {


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(HttpMethod.DELETE, "/rest/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.POST, "/rest/**").hasRole("ADMIN") // TODO doesn't work post requests
                        .requestMatchers(HttpMethod.PATCH, "/rest/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/rest/**").hasAnyRole("ADMIN", "OBSERVER")
                        .anyRequest().authenticated()
                )
                .formLogin()
                .and()
                .httpBasic();

        return http.build();
    }


    @Bean
    protected UserDetailsService userDetailsService() {
        List<UserDetails> springSecurityUserList = new ArrayList<>();
        springSecurityUserList.add(User.builder()
                .username("admin")
                .password(passwordEncoder().encode("admin"))
                .roles(Role.ADMIN.name())
                .build());
        springSecurityUserList.add(User.builder()
                .username("observer")
                .password(passwordEncoder().encode("observer"))
                .roles(Role.OBSERVER.name())
                .build());
        return new InMemoryUserDetailsManager(
                springSecurityUserList
        );
    }

    @Bean
    protected PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(12);
    }
}