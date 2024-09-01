package com.tracker.expensetracker.Dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(
        description = "Category DTO object"
)
public record CategoryDto(Long id,
                          @Schema(
                                  description = "This is category Name"
                          )
                          String categoryName) {
}
