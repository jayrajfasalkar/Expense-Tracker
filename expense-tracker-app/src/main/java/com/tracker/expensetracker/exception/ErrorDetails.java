package com.tracker.expensetracker.exception;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Schema(
        description = "Error details DTO"
)
public class ErrorDetails {

    @Schema(
            description = "Error occurred timestamp"
    )
    private LocalDateTime timestamp;

    @Schema(
            description = "error message"
    )
    private String message;

    @Schema(
            description = "error details"
    )
    private String details;

    @Schema(
            description = "error description"
    )
    private String errorCode;
}
