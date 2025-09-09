package com.hmm.expenses_api_transactions.infrastructure.adapter.web;


import com.hmm.expenses_api_transactions.common.exceptions.AccountNotFoundException;
import com.hmm.expenses_api_transactions.infrastructure.adapter.web.dto.TransactionDto;
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

    @PostMapping("")
    public ResponseEntity<?> createExpense(@RequestBody TransactionDto expenseDto) throws AccountNotFoundException{
        TransactionDto expenseDtoResponse = transactionWebAdapter.create(expenseDto);
        return createResponse(expenseDtoResponse,200,"Expense created successfully");
    }
}
