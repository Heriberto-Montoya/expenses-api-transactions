package com.hmm.expenses_api_transactions.application.usecase.transaction;

import com.hmm.expenses_api_transactions.application.domain.models.Transaction;
import com.hmm.expenses_api_transactions.common.exceptions.AccountNotFoundException;

public interface CreateTransaction {
    Transaction create(Transaction expense) throws AccountNotFoundException;
}
