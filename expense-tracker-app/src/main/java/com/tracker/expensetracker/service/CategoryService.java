package com.tracker.expensetracker.service;

import com.tracker.expensetracker.Dto.CategoryDto;

import java.util.List;

public interface CategoryService {

    CategoryDto createCategory(CategoryDto categoryDto);

    CategoryDto getCategoryById(Long id);

    List<CategoryDto> getAllCategories();

    CategoryDto updateCategory(Long categordId, CategoryDto categoryDto);

    void deleteCategory(Long categordId);

}
