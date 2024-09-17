package com.acme.security_service.repository;

import com.acme.security_service.model.*;
import org.springframework.data.jpa.repository.*;

import java.util.*;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail (String email);
    Optional<User> findByUsernameOrEmail (String username, String email);
}