package com.iea.transaction_management.controller;

import com.iea.transaction_management.model.entity.Transaction;
import com.iea.transaction_management.model.service.AbstractTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/transaction")
@RestController
public class TransactionController
{
    @Autowired
    private AbstractTransactionService transactionService;

    // api/transaction/userID
    @GetMapping("{userID}")
    public ResponseEntity<List<Transaction>> getTransactionsOfUser(@PathVariable Integer userID)
    {
        return ResponseEntity.ok(transactionService.findAllTransactionsOfUser(userID));
    }

    // api/transaction
    @GetMapping
    public ResponseEntity<List<Transaction>> getAllTransactions()
    {
        return ResponseEntity.ok(transactionService.getAll());
    }

    @DeleteMapping
    public ResponseEntity deleteTransactionByID(@PathVariable  Integer transactionID)
    {
        transactionService.deleteByID(transactionID);

        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Transaction> saveTransaction(@RequestBody Transaction transaction)
    {
        Transaction savedTransaction = transactionService.save(transaction);

        return new ResponseEntity<>(savedTransaction, HttpStatus.CREATED);
    }
}
