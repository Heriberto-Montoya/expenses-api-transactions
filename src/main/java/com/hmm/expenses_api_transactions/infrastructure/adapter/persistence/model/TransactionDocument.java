package com.hmm.expenses_api_transactions.infrastructure.adapter.persistence.model;

import com.hmm.expenses_api_transactions.common.enums.TransactionType;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDate;

@Document(collection = "transactions")
@Data
@Builder
public class TransactionDocument {
    @Id
    private String id;
    @Field("accountId")
    private String accountId;
    private Double amount;
    private String categoryId;
    private String description;
    private TransactionType type;
    private LocalDate transaction_date;


}