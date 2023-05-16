package com.example.restaurentManagementService.repository;

import com.example.restaurentManagementService.model.AuthenticationToken;
import com.example.restaurentManagementService.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAuthenticationRepository extends JpaRepository<AuthenticationToken, Long> {
    AuthenticationToken findByUser(User user);

    AuthenticationToken findFirstByToken(String token);
}
