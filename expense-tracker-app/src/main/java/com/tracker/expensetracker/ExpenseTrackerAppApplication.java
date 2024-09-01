package com.tracker.expensetracker;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(
		info = @Info(
				title = "Expense Tracker Rest API Documentation",
				description = "expense tracker description",
				version = "v1.0",
				contact = @Contact(
						name = "JAYRAJ",
						email = "jayrajfasalkar@gmail.com",
						url = "https://www.instagram.com/jayrajfasalkar/"
				),
				license = @License(
						name = "Apache 2.0 blah",
						url = "https://www.instagram.com/jayrajfasalkar/"
				)
		),
		externalDocs = @ExternalDocumentation(
				description = "external documentation for expense tracker",
				url = "https://www.instagram.com/jayrajfasalkar/"
		)
)
@SpringBootApplication
public class ExpenseTrackerAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExpenseTrackerAppApplication.class, args);
	}

}
