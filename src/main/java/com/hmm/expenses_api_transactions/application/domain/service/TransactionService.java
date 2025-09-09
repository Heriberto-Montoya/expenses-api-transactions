package com.hmm.expenses_api_transactions.application.domain.service;

import com.hmm.expenses_api_transactions.application.domain.models.Transaction;
import com.hmm.expenses_api_transactions.application.port.transaction.TransactionRepositoryPort;
import com.hmm.expenses_api_transactions.application.port.transaction.TransactionWebPort;
import com.hmm.expenses_api_transactions.common.exceptions.AccountNotFoundException;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransactionService implements TransactionWebPort {
    private final TransactionRepositoryPort transactionRepositoryPort;

    @Override
    public Transaction create(Transaction expense) throws AccountNotFoundException {
        return transactionRepositoryPort.create(expense);
    }
}
