package com.hamza.Gestion_bank.services.imp;

import com.hamza.Gestion_bank.dto.AccountDTO;
import com.hamza.Gestion_bank.dto.UserDTO;
import com.hamza.Gestion_bank.entities.Account;
import com.hamza.Gestion_bank.exceptions.AccountNotFoundException;
import com.hamza.Gestion_bank.exceptions.SoldeInsuffisantException;
import com.hamza.Gestion_bank.mappers.AcountMapper;
import com.hamza.Gestion_bank.mappers.UserMapper;
import com.hamza.Gestion_bank.repositories.AccountRepository;
import com.hamza.Gestion_bank.services.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AccountServiceImp implements AccountService {
    private final AccountRepository accountRepository;

    @Override
    public AccountDTO addOneAccount(AccountDTO accountDTO) {
        return AcountMapper.INSTANCE
                .mapAcountToAcountDTO(accountRepository.save(AcountMapper.INSTANCE.mapAccountDTOToAccount(accountDTO)));
    }

    @Override
    public List<AccountDTO> fetchAllAccount() {
        List<Account> accounts = accountRepository.findAll();
        return accounts.stream()
                .map(AcountMapper.INSTANCE::mapAcountToAcountDTO)
                .collect(Collectors.toList());
    }

    @Override
    public BigDecimal consulterSolde(Long accountId) {
        Optional<Account> account = accountRepository.findById(accountId);
        if (account.isPresent()) {
            return account.get().getSolde();
        } else {
            throw new AccountNotFoundException("ce compte n'existe pas" + accountId);
        }

    }

    @Override
    public List<AccountDTO> fetchAccountByUser(UserDTO userDTO) {
        List<Account> accounts = accountRepository.findByUser(UserMapper.INSTANCE.mapUserDTOToUser(userDTO));
        return accounts.stream()
                .map(AcountMapper.INSTANCE::mapAcountToAcountDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteAccountById(Long id) {
        accountRepository.deleteById(id);
    }

    @Override
    public void effectuerDepot(Long accountId, BigDecimal montant) {
        Optional<Account> account = accountRepository.findById(accountId);
        if (account.isPresent()) {
            account.get().setSolde(account.get().getSolde().add(montant));
            accountRepository.save(account.get());
        } else throw new AccountNotFoundException("ce compte n'existe pas" + accountId);
    }

    @Override
    public void effectuerRetrait(Long accountId, BigDecimal montant) {
        Optional<Account> account = accountRepository.findById(accountId);
        if (account.isPresent()) {
            BigDecimal nouveauSolde = account.get().getSolde().subtract(montant);
            if (nouveauSolde.compareTo(BigDecimal.ZERO) > 0) {
                account.get().setSolde(account.get().getSolde().subtract(montant));
                accountRepository.save(account.get());
            } else
                throw new SoldeInsuffisantException("Votre solde est insuffisant pour effectuer le retrait");
        } else {
            throw new AccountNotFoundException("Ce compte n'existe pas" + accountId);
        }
    }

    @Override
    public void effectuerTransfert(Long accountSourceId, Long accountDestinationId, BigDecimal montant) {
        Optional<Account> accountSource = accountRepository.findById(accountSourceId);
        Optional<Account> accountDestination = accountRepository.findById(accountDestinationId);
        if (accountDestination.isPresent() && accountSource.isPresent()) {
            BigDecimal nouveauSoldeSource = accountSource.get().getSolde().subtract(montant);
            if (nouveauSoldeSource.compareTo(BigDecimal.ZERO) > 0) {
                BigDecimal nouveauSoldeDestination = accountDestination.get().getSolde().add(montant);
                accountSource.get().setSolde(nouveauSoldeSource);
                accountDestination.get().setSolde(nouveauSoldeDestination);
                accountRepository.save(accountSource.get());
                accountRepository.save(accountDestination.get());
            } else {
                throw new SoldeInsuffisantException("Votre solde est insuffisant pour effectuer la transaction");
            }
        } else {
            throw new AccountNotFoundException("compte Source ou compte destination n'existe pas");
        }
    }
}