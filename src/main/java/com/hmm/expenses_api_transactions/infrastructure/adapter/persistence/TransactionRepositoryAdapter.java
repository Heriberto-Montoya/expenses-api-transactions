package com.hmm.expenses_api_transactions.infrastructure.adapter.persistence;

import com.hmm.expenses_api_transactions.application.domain.models.Transaction;
import com.hmm.expenses_api_transactions.application.port.transaction.TransactionRepositoryPort;
import com.hmm.expenses_api_transactions.infrastructure.adapter.messaging.transaction.TransactionProducer;
import com.hmm.expenses_api_transactions.infrastructure.adapter.persistence.model.TransactionDocument;
import com.hmm.expenses_api_transactions.common.exceptions.AccountNotFoundException;
import com.hmm.expenses_api_transactions.common.exceptions.InvalidAmountException;
import com.hmm.expenses_api_transactions.infrastructure.mappers.TransactionMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class TransactionRepositoryAdapter implements TransactionRepositoryPort {

    private final TransactionRepository transactionRepository;
    private final TransactionMapper transactionMapper;
    private final TransactionProducer transactionProducer;

    @Override
    public Transaction create(Transaction expense) throws AccountNotFoundException {
        if(expense.getAmount() <= 0) throw new InvalidAmountException("The transaction amount cannot be less than or equal to zero.");
        expense.setTransaction_date(LocalDate.now());

        Optional<TransactionDocument> existingTransaction = transactionRepository.findById(expense.getId());
        if(existingTransaction.isEmpty()) throw new AccountNotFoundException("The account with id " + expense.getId() + " does not exist.");

        TransactionDocument expenseDocument = transactionRepository.save(transactionMapper.toDocument(expense));
        transactionProducer.sendTransaction(transactionMapper.toModel(expenseDocument));

        return  transactionMapper.toModel(expenseDocument);
    }
}
