package com.hmm.expenses_api_transactions.application.usecase.transaction;

import com.hmm.expenses_api_transactions.application.domain.models.Transaction;

public interface CreateTransaction {
    Transaction create(Transaction expense);
}
