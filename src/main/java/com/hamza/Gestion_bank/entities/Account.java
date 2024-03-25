package com.hamza.Gestion_bank.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account  extends  BaseEntity{
    @Column(nullable = false)
    private BigDecimal solde;
    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnoreProperties("accounts")
    private User user;
    @OneToMany(mappedBy = "accountSource", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("accountSource")
    private List <Transaction> transactions;
}
