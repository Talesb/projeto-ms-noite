package com.acme.security_service.service;

import com.acme.security_service.model.User;
import com.acme.security_service.repository.*;
import lombok.*;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.*;

import java.util.*;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;

    public List<User> getAll () {
        return userRepository.findAll();
    }

    public User save (User user) {
        return userRepository.save(user);
    }

    public Optional<User> findByEmail (String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public UserDetails loadUserByUsername (String username) throws UsernameNotFoundException {
        return findByEmail(username).orElseThrow(
                () -> new UsernameNotFoundException("User not found with username: " + username));
    }
}