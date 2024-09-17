package com.acme.revisao.config;

import com.acme.revisao.security.*;
import lombok.*;
import org.springframework.context.annotation.*;
import org.springframework.security.config.annotation.web.builders.*;
import org.springframework.security.config.annotation.web.configuration.*;
import org.springframework.security.config.annotation.web.configurers.*;
import org.springframework.security.web.*;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    private final JwtConverter jwtConverter;

    @Bean
    public SecurityFilterChain securityFilterChain (HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable).authorizeHttpRequests((authz) -> {
            authz.requestMatchers("/hello").permitAll().requestMatchers("/**").hasRole("ADMIN")
                    .requestMatchers("/revisao").hasAnyRole("ADMIN", "USER").anyRequest().permitAll();

        });
        http.oauth2ResourceServer(oauth2 -> oauth2.jwt(jwt -> jwt.jwtAuthenticationConverter(jwtConverter)));
        return http.build();

    }
}