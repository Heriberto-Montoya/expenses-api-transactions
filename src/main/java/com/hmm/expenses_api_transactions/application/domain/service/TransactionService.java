package com.hmm.expenses_api_transactions.application.domain.service;

import com.hmm.expenses_api_transactions.application.domain.models.Transaction;
import com.hmm.expenses_api_transactions.application.port.transaction.TransactionRepositoryPort;
import com.hmm.expenses_api_transactions.application.port.transaction.TransactionWebPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransactionService implements TransactionWebPort {
    private final TransactionRepositoryPort transactionRepositoryPort;

    @Override
    public Transaction create(Transaction expense) {
        return transactionRepositoryPort.create(expense);
    }
}
