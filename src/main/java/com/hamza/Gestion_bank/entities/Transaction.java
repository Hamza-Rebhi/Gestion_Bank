package com.hamza.Gestion_bank.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Transaction  extends  BaseEntity{
    @Enumerated
    @Column(nullable = false)
    private Type type;
    @Column(nullable = false)
    private BigDecimal montant;
    @ManyToOne
    @JoinColumn(name = "account_source_id")
    @JsonIgnoreProperties("transactions")
    private Account accountSource;
    @ManyToOne
    @JoinColumn(name = "account_destination_id")
    @JsonIgnoreProperties("transactions")
    private Account accountDestination;
    private Date date;
}
