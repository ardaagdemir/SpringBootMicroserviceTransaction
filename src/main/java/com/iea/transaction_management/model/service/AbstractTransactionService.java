package com.iea.transaction_management.model.service;

import com.iea.transaction_management.model.entity.Transaction;
import com.iea.transaction_management.model.repository.TransactionRepository;

import java.util.List;

public abstract class AbstractTransactionService implements EntityService<Transaction, Integer>
{
    protected TransactionRepository transactionRepository;

    public abstract List<Transaction> findAllTransactionsOfUser(Integer userID);
}
