package com.hamza.Gestion_bank.controller;

import com.hamza.Gestion_bank.dto.AccountDTO;
import com.hamza.Gestion_bank.dto.UserDTO;
import com.hamza.Gestion_bank.services.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class AccountController {
    private final AccountService accountService;

    @PostMapping("/addAccount")
    public ResponseEntity<?> addOneAccount(@RequestBody AccountDTO accountDTO) {
        try {
            AccountDTO savedAccount = accountService.addOneAccount(accountDTO);
            return new ResponseEntity<>(savedAccount, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("une erreur est faite lors de creation.", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/allAccount")
    public ResponseEntity<List<AccountDTO>> getAllAccount() {
        return ResponseEntity.ok(accountService.fetchAllAccount());
    }
    @GetMapping("/consulterSolde/{accountId}")
    public ResponseEntity<BigDecimal> consulterSolde(@PathVariable Long accountId) {
        return ResponseEntity.ok(accountService.consulterSolde(accountId));
    }
    @GetMapping("/accountBuUser")
  public ResponseEntity<List<AccountDTO>> fetchAccountByUser(@RequestBody UserDTO userDTO)
    {
        return ResponseEntity.ok(accountService.fetchAllAccount());
    }
    @DeleteMapping("/delAccount/{id}")
   public  void deleteAccountById(@PathVariable Long id){
        accountService.deleteAccountById(id);
    }
    @PutMapping("/depot/{accountId}/{montant}")
    public void effectuerDepot(@PathVariable Long accountId,
                               @PathVariable BigDecimal montant){
        accountService.effectuerDepot(accountId,montant);
    }
    @PutMapping("/retrait/{accountId}/{montant}")
    public void  effectuerRetrait(@PathVariable Long accountId,
                                  @PathVariable BigDecimal montant){
        accountService.effectuerRetrait(accountId,montant);
    }
    @PutMapping("/transfert/{accountSourceId}/{accountDestinationId}/{montant}")
    public void effectuerTransfert(@PathVariable Long accountSourceId,
                                   @PathVariable Long accountDestinationId,
                                   @PathVariable BigDecimal montant){
    accountService.effectuerTransfert(accountSourceId,accountDestinationId,montant);
    }


}
