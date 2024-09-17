package com.acme.security_service.controller;

import com.acme.security_service.payload.*;
import com.acme.security_service.service.*;
import lombok.*;
import lombok.extern.slf4j.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
@Slf4j
public class SecurityController {

    private final UserService userService;
    private final AuthService authService;

    @PostMapping("/auth")
    public ResponseEntity<?> auth (@RequestBody LoginRequest loginRequest) {
        return ResponseEntity.ok(new ResponsePayload(authService.authenticate(loginRequest)));
    }

}
