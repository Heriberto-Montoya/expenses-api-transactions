package com.hmm.expenses_api_transactions.infrastructure.adapter.web.dto;

import com.hmm.expenses_api_transactions.common.enums.TransactionType;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class TransactionDto {
    private String id;
    private String accountId;
    private Double amount;
    private String categoryId;
    private String description;
    private TransactionType type;
    private LocalDate transaction_date;
}
