package com.hamza.Gestion_bank.services;

import com.hamza.Gestion_bank.dto.AccountDTO;
import com.hamza.Gestion_bank.dto.UserDTO;

import java.math.BigDecimal;
import java.util.List;

public interface AccountService {
    AccountDTO addOneAccount(AccountDTO accountDTO);
    List<AccountDTO> fetchAllAccount();
    BigDecimal consulterSolde(Long accountId);
   List<AccountDTO> fetchAccountByUser(UserDTO userDTO);
    void deleteAccountById(Long id);

    void effectuerDepot(Long accountId, BigDecimal montant);
    void  effectuerRetrait(Long accountId, BigDecimal montant);
    void effectuerTransfert(Long accountSourceId, Long accountDestinationId, BigDecimal montant);
}
