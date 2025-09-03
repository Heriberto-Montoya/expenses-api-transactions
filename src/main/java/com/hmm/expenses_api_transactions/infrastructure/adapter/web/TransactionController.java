package com.hmm.expenses_api_transactions.infrastructure.adapter.web;


import com.hmm.expenses_api_transactions.infrastructure.adapter.web.dto.TransactionDto;
import com.hmm.expenses_api_transactions.infrastructure.mappers.TransactionMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/expenses")
@RequiredArgsConstructor
public class TransactionController extends BaseController {
    private final TransactionWebAdapter transactionWebAdapter;
    private final TransactionMapper expenseMapper;

    @PostMapping("")
    public ResponseEntity<?> createExpense(@RequestBody TransactionDto expenseDto){
        TransactionDto expenseDtoResponse = transactionWebAdapter.create(expenseDto);
        return createResponse(expenseDtoResponse,200,"Expense created successfully");
    }
}
