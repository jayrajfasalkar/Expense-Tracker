package com.tracker.expensetracker.mapper;

import com.tracker.expensetracker.Dto.CategoryDto;
import com.tracker.expensetracker.Dto.ExpenseDto;
import com.tracker.expensetracker.entity.Category;
import com.tracker.expensetracker.entity.Expense;

public class ExpenseMapper {

    public static ExpenseDto mapToExpenseDto(Expense expense) {
        ExpenseDto expenseDto = new ExpenseDto(expense.getId(),
                expense.getAmount(),
                expense.getExpenseDate(),
                new CategoryDto(expense.getCategory().getId(), expense.getCategory().getCategoryName())
                );

        return expenseDto;
    }

    public static Expense mapToExpense(ExpenseDto expenseDto) {

//        what is the difference b/w this and below
//        Category category = new Category();
//        category.setId(expenseDto.categoryDto().id());

        Expense expense = new Expense(expenseDto.id(), expenseDto.amount(), expenseDto.expenseDate(),
                new Category(expenseDto.categoryDto().id(), expenseDto.categoryDto().categoryName()));

        return expense;
    }
}
