package com.acme.security_service.service;

import com.acme.security_service.model.*;
import com.acme.security_service.payload.*;
import lombok.*;
import org.springframework.security.authentication.*;
import org.springframework.security.core.*;
import org.springframework.security.crypto.password.*;
import org.springframework.stereotype.*;

import java.util.*;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public User register (RegisterRequest registerRequest) {
        User user = User.builder().name(registerRequest.firstName()).email(registerRequest.email())
                .password(passwordEncoder.encode(registerRequest.password())).lastName(registerRequest.lastName())
                .role(Role.USER).build();
        return userService.save(user);
    }

    public String authenticate (LoginRequest loginRequest) {
        UsernamePasswordAuthenticationToken userAuth = new UsernamePasswordAuthenticationToken(loginRequest.email(),
                loginRequest.password());
        Authentication authenticate = authenticationManager.authenticate(userAuth);
        User usuarioAutenticado = (User) authenticate.getPrincipal();
        return jwtService.generateToken(usuarioAutenticado, getRoles(authenticate.getAuthorities()));

    }

    public List<String> getRoles (Collection<? extends GrantedAuthority> authorities) {
        return authorities.stream().map(GrantedAuthority::getAuthority).toList();
    }

}