package com.hmm.expenses_api_transactions.infrastructure.adapter.persistence;

import com.hmm.expenses_api_transactions.infrastructure.adapter.persistence.model.TransactionDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TransactionRepository extends MongoRepository<TransactionDocument, String> {
}
