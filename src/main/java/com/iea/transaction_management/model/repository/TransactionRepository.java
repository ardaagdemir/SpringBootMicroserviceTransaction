package com.iea.transaction_management.model.repository;

import com.iea.transaction_management.model.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Integer>
{
    List<Transaction> findAllByUserID(Integer userID);
}
