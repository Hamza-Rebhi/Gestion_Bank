package com.hamza.Gestion_bank.repositories;

import com.hamza.Gestion_bank.entities.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserInfo,Long> {
    UserInfo findByEmail(String email);
    Optional<UserInfo> findByNom(String userName);

}
