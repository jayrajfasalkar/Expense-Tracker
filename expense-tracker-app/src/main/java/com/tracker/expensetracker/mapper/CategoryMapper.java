package com.tracker.expensetracker.mapper;

import com.tracker.expensetracker.Dto.CategoryDto;
import com.tracker.expensetracker.entity.Category;

public class CategoryMapper {

    public static Category mapToCategory(CategoryDto categoryDto) {
        return new Category(categoryDto.id(),
                            categoryDto.categoryName());
    }

    public static CategoryDto mapToCategoryDto(Category category) {
        return new CategoryDto(category.getId(),
                category.getCategoryName());
    }
}
