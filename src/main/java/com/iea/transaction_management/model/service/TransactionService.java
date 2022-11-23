package com.iea.transaction_management.model.service;

import com.iea.transaction_management.model.entity.Transaction;
import com.iea.transaction_management.utility.ExceptionMessageType;
import com.iea.transaction_management.utility.Util;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService extends AbstractTransactionService
{
    @Override
    public List<Transaction> findAllTransactionsOfUser(Integer userID)
    {
        return transactionRepository.findAllByUserID(userID);
    }

    @Override
    public Transaction findByID(Integer id)
    {
        return transactionRepository.findById(id)
                .orElseThrow( () -> new RuntimeException(ExceptionMessageType.FIND_BY_ID.getValue() ) );
    }

    @Override
    public List<Transaction> getAll()
    {
        return transactionRepository.findAll();
    }

    @Override
    public Transaction save(Transaction entity)
    {
        try
        {
            if(entity != null)
            {
                return transactionRepository.save(entity);
            }

            return  new Transaction();
        }
        catch (IllegalArgumentException e)
        {
            Util.showGeneralExceptionMessage(e);

            return  new Transaction();
        }
        catch (OptimisticLockingFailureException e)
        {
            Util.showGeneralExceptionMessage(e);

            return new Transaction();
        }
    }

    @Override
    public void deleteByID(Integer id)
    {
        try
        {
            if(id != null)
            {
                transactionRepository.deleteById(id);
            }
        }
        catch (IllegalArgumentException e)
        {
            Util.showGeneralExceptionMessage(e);
        }
    }
}
