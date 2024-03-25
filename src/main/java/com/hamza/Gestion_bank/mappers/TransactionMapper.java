package com.hamza.Gestion_bank.mappers;

import com.hamza.Gestion_bank.dto.TransactionDTO;
import com.hamza.Gestion_bank.entities.Transaction;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TransactionMapper {
    TransactionMapper INSTANCE= Mappers.getMapper(TransactionMapper.class);
    TransactionDTO mapTransactionToTransactionDTO(Transaction transaction);
    Transaction mapTransactionDTOToTransaction(TransactionDTO transactionDTO);
}
