package com.acme.gateway.security;

import com.acme.gateway.service.*;
import lombok.*;
import lombok.extern.slf4j.*;
import org.springframework.cloud.gateway.filter.*;
import org.springframework.cloud.gateway.filter.factory.*;
import org.springframework.http.*;
import org.springframework.stereotype.*;

@Service
@Slf4j
public class UserAuthenticationGatewayFilterFactory
        extends AbstractGatewayFilterFactory<UserAuthenticationGatewayFilterFactory.Config> {
    private final JwtUtil jwtUtil;

    public UserAuthenticationGatewayFilterFactory (JwtUtil jwtUtil) {
        super(Config.class);
        this.jwtUtil = jwtUtil;
    }

    @Override
    public GatewayFilter apply (Config config) {
        return (exchange, chain) -> {
            try {
                log.info("Incoming request: {} {}", exchange.getRequest().getMethod().name(),
                        exchange.getRequest().getPath());
                String accessToken = exchange.getRequest().getHeaders().get(config.getHeaderName()).stream().findFirst()
                        .orElseThrow();
                String user = jwtUtil.decodeToken(accessToken);
                exchange.getRequest().mutate().header("userID", user).build();
                return chain.filter(exchange);
            } catch (Exception e) {
                exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
                return exchange.getResponse().setComplete();
            }
        };
    }

    @Getter
    @Setter
    @Builder
    public static class Config {
        private String headerName;
    }
}