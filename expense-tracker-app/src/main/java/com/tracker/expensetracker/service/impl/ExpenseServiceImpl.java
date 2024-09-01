package com.tracker.expensetracker.service.impl;

import com.tracker.expensetracker.Dto.ExpenseDto;
import com.tracker.expensetracker.entity.Category;
import com.tracker.expensetracker.entity.Expense;
import com.tracker.expensetracker.exception.ResourceNotFoundException;
import com.tracker.expensetracker.mapper.CategoryMapper;
import com.tracker.expensetracker.mapper.ExpenseMapper;
import com.tracker.expensetracker.repository.ExpenseRepository;
import com.tracker.expensetracker.service.ExpenseService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class ExpenseServiceImpl implements ExpenseService {

    private ExpenseRepository expenseRepository;

    @Override
    public ExpenseDto createExpense(ExpenseDto expenseDto) {
        Expense expense = ExpenseMapper.mapToExpense(expenseDto);
        expense = expenseRepository.save(expense);
        return ExpenseMapper.mapToExpenseDto(expense);
    }

    @Override
    public ExpenseDto getExpenseById(Long id) {
        Expense expense = expenseRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Expense not found beta"));

        return ExpenseMapper.mapToExpenseDto(expense);
    }

    @Override
    public List<ExpenseDto> getAllExpenses() {
        //expenses().stream......what is that
        List<Expense> expenses = expenseRepository.findAll();
        List<ExpenseDto> expenseDtos = new ArrayList<>();
        for(Expense expense: expenses){
            expenseDtos.add(ExpenseMapper.mapToExpenseDto(expense));
        }
        return expenseDtos;
    }

    @Override
    public ExpenseDto updateExpense(Long id, ExpenseDto expenseDto) {
        Expense expense = expenseRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Expense not found beta"));
        expense.setAmount(expenseDto.amount());
        expense.setExpenseDate(expenseDto.expenseDate());
        Category category = CategoryMapper.mapToCategory(expenseDto.categoryDto());
        expense.setCategory(category);
        expenseRepository.save(expense);
        return ExpenseMapper.mapToExpenseDto(expense);
    }

    @Override
    public void deleteExpense(Long id) {
        Expense expense = expenseRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Expense not found beta"));
        expenseRepository.delete(expense);
    }
}
