package com.hamza.Gestion_bank.dto;

import com.hamza.Gestion_bank.entities.Account;
import com.hamza.Gestion_bank.entities.Type;

import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionDTO {
    private Type type;
    @Positive(message = "le montant doit étre positif")
    private BigDecimal montant;

    private Account accountSource;

    private Account accountDestination;
    @DateTimeFormat
    private Date date;

}
