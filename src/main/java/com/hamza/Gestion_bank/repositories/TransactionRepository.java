package com.hamza.Gestion_bank.repositories;

import com.hamza.Gestion_bank.entities.Account;
import com.hamza.Gestion_bank.entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction,Long> {
    List<Transaction>findByAccountSource(Account accountSource);
}
