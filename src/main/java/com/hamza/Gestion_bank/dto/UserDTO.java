package com.hamza.Gestion_bank.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.hamza.Gestion_bank.entities.Account;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.NamedEntityGraph;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    @NotBlank
    private String nom;
    @Email
    private String email;
    @NotBlank
    private String password;
    private List<Account> accounts;
}
