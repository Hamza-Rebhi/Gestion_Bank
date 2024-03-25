package com.hamza.Gestion_bank.controller;

import com.hamza.Gestion_bank.dto.TransactionDTO;
import com.hamza.Gestion_bank.services.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class TransactionController {
    private final TransactionService transactionService;
    @GetMapping("/transactionByAccountSource/{accountSourceId}")
   public ResponseEntity<List<TransactionDTO>> getTransactionsByAccountSource(Long accountSourceId){
        return ResponseEntity.ok(transactionService.getTransactionsByAccountSource(accountSourceId));
    }
    @DeleteMapping("/delTransaction/{idTransaction}")
   public void deleteTransactionById(Long idTransaction){
        transactionService.deleteTransactionById(idTransaction);
   }
   @GetMapping("/allTransaction")
    public ResponseEntity<List<TransactionDTO>> getAllTransactionB(){
        return ResponseEntity.ok(transactionService.getAllTransactionB());
   }
   @GetMapping("/transactionById/{idTransaction}")
   public  ResponseEntity<TransactionDTO> getTransactionById(Long idTransaction){
        return ResponseEntity.ok(transactionService.getTransactionById(idTransaction));
   }
}
