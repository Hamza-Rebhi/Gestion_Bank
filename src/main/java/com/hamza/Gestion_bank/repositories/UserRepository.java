package com.hamza.Gestion_bank.repositories;

import com.hamza.Gestion_bank.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByEmail(String email);
    Optional<User> findByName(String userName);

}
