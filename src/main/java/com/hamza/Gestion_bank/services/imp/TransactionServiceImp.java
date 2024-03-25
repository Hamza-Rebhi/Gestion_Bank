package com.hamza.Gestion_bank.services.imp;

import com.hamza.Gestion_bank.dto.TransactionDTO;
import com.hamza.Gestion_bank.entities.Account;
import com.hamza.Gestion_bank.entities.Transaction;
import com.hamza.Gestion_bank.exceptions.AccountNotFoundException;
import com.hamza.Gestion_bank.exceptions.TransactionNotFoundException;
import com.hamza.Gestion_bank.mappers.TransactionMapper;
import com.hamza.Gestion_bank.repositories.AccountRepository;
import com.hamza.Gestion_bank.repositories.TransactionRepository;
import com.hamza.Gestion_bank.services.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TransactionServiceImp implements TransactionService {
    private final TransactionRepository transactionRepository;
    private final AccountRepository accountRepository;
    @Override
    public List<TransactionDTO> getTransactionsByAccountSource(Long accountSourceId) {
        Optional<Account> accountSource= accountRepository.findById(accountSourceId);
      if (accountSource.isPresent()){
          return (transactionRepository.findByAccountSource(accountSource.get())).stream().map(TransactionMapper.INSTANCE::mapTransactionToTransactionDTO).collect(Collectors.toList());
      }
        else {throw new AccountNotFoundException("Ce compte n'existe pas");
      }
    }

    @Override
    public void deleteTransactionById(Long idTransaction) {
         transactionRepository.deleteById(idTransaction);
    }

    @Override
    public List<TransactionDTO> getAllTransactionB() {
        return transactionRepository.findAll()
                .stream().map(TransactionMapper.INSTANCE::mapTransactionToTransactionDTO)
                .collect(Collectors.toList());
    }

    @Override
    public TransactionDTO getTransactionById(Long idTransaction) {
       Optional<Transaction> transaction=transactionRepository.findById(idTransaction);
       if(transaction.isPresent()){
           return TransactionMapper.INSTANCE.mapTransactionToTransactionDTO( transaction.get());
       }
       else{
           throw new TransactionNotFoundException("cette transaction n'existe pas");
       }
    }
}
