package com.hamza.Gestion_bank.repositories;

import com.hamza.Gestion_bank.entities.Account;
import com.hamza.Gestion_bank.entities.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountRepository  extends JpaRepository<Account,Long> {
    List<Account> findByUser(UserInfo user);
}
