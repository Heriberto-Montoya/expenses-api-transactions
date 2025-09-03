package com.hmm.expenses_api_transactions.infrastructure.adapter.web;

import com.hmm.expenses_api_transactions.application.domain.models.Transaction;
import com.hmm.expenses_api_transactions.application.port.transaction.TransactionWebPort;
import com.hmm.expenses_api_transactions.infrastructure.adapter.web.dto.TransactionDto;
import com.hmm.expenses_api_transactions.infrastructure.mappers.TransactionMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TransactionWebAdapter {
    private final TransactionWebPort transactionWebPort;
    private final TransactionMapper transactionMapper;

    public TransactionDto create(TransactionDto transactionDto){
        Transaction transaction = transactionWebPort.create(transactionMapper.toModel(transactionDto));
        return transactionMapper.toDto(transaction);
    }
}
