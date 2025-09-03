package com.hmm.expenses_api_transactions.infrastructure.mappers;

import com.hmm.expenses_api_transactions.application.domain.models.Transaction;
import com.hmm.expenses_api_transactions.infrastructure.adapter.persistence.model.TransactionDocument;
import com.hmm.expenses_api_transactions.infrastructure.adapter.web.dto.TransactionDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TransactionMapper {
    TransactionDocument toDocument(Transaction transaction);
    Transaction toModel(TransactionDocument transactionDocument);
    Transaction toModel(TransactionDto transactionDto);
    TransactionDto toDto(Transaction transaction);
}
