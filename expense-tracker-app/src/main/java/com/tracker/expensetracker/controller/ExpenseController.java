package com.tracker.expensetracker.controller;

import com.tracker.expensetracker.Dto.ExpenseDto;
import com.tracker.expensetracker.service.ExpenseService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("api/expense")
public class ExpenseController {

    private ExpenseService expenseService;

    @PostMapping
    public ResponseEntity<ExpenseDto> createExpense(@RequestBody ExpenseDto expenseDto) {
        expenseDto = expenseService.createExpense(expenseDto);

        return new ResponseEntity<>(expenseDto, HttpStatus.CREATED);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<ExpenseDto> getExpenseById(@PathVariable Long id) {
        ExpenseDto expenseDto = expenseService.getExpenseById(id);
        return ResponseEntity.ok(expenseDto);
    }

    @GetMapping("/getall")
    public ResponseEntity<List<ExpenseDto>> getAllExpenses() {
        List<ExpenseDto> expenseDtos = expenseService.getAllExpenses();
        return ResponseEntity.ok(expenseDtos);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ExpenseDto> updateExpense(@PathVariable Long id, @RequestBody ExpenseDto expenseDto) {
        ExpenseDto expenseDto1 = expenseService.updateExpense(id, expenseDto);
        return ResponseEntity.ok(expenseDto1);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteExpense(@PathVariable Long id) {
        expenseService.deleteExpense(id);
        return ResponseEntity.ok("Expense Deleted Successfully");
    }
}















