package com.hamza.Gestion_bank.services;

import com.hamza.Gestion_bank.dto.TransactionDTO;
import com.hamza.Gestion_bank.entities.Transaction;

import java.util.List;

public interface TransactionService {
    List<TransactionDTO> getTransactionsByAccountSource(Long accountSourceId);
    void deleteTransactionById(Long idTransaction);
    List<TransactionDTO> getAllTransactionB();
    TransactionDTO getTransactionById(Long idTransaction);
}
