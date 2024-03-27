package com.hamza.Gestion_bank.dto;

import com.hamza.Gestion_bank.entities.Transaction;
import com.hamza.Gestion_bank.entities.UserInfo;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountDTO {
    @Positive
    private BigDecimal solde;

    private UserInfo user;

    private List<Transaction> transactions;
}
