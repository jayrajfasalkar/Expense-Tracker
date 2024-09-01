package com.tracker.expensetracker.Dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;
import java.time.LocalDate;

@Schema(
        description = "Expense DTO object"
)
public record ExpenseDto(Long id,
                         @Schema(
                                 description = "Expense amount"
                         )
                         BigDecimal amount,

                         @Schema(
                                 description = "Expense date"
                         )
                         LocalDate expenseDate,

                         @Schema(
                                 description = "Associated category"
                         )
                         CategoryDto categoryDto) {
}
