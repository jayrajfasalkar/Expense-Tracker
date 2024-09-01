package com.tracker.expensetracker.service.impl;

import com.tracker.expensetracker.Dto.CategoryDto;
import com.tracker.expensetracker.entity.Category;
import com.tracker.expensetracker.exception.ResourceNotFoundException;
import com.tracker.expensetracker.mapper.CategoryMapper;
import com.tracker.expensetracker.repository.CategoryRepository;
import com.tracker.expensetracker.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }//instead of this cons we can use Autowired or use @Allargcons annotation

    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {
        Category category = CategoryMapper.mapToCategory(categoryDto);
        category = categoryRepository.save(category);
        return CategoryMapper.mapToCategoryDto(category);
    }

    @Override
    public CategoryDto getCategoryById(Long id) {
        Category category = categoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Category not found beta"));
        return CategoryMapper.mapToCategoryDto(category);
    }

    @Override
    public List<CategoryDto> getAllCategories() {
        List<Category> categories = categoryRepository.findAll();

        List<CategoryDto> categoryDtos = new ArrayList<>();

        for(Category category: categories) {
            categoryDtos.add(CategoryMapper.mapToCategoryDto(category));
        }
        return categoryDtos;
    }

    @Override
    public CategoryDto updateCategory(Long categordId, CategoryDto categoryDto) {
        Category category = categoryRepository.findById(categordId).orElseThrow(() -> new ResourceNotFoundException("Category not found beta"));
        category.setCategoryName(categoryDto.categoryName());
        category = categoryRepository.save(category);
        return CategoryMapper.mapToCategoryDto(category);
    }

    @Override
    public void deleteCategory(Long categordId) {
        Category category = categoryRepository.findById(categordId).orElseThrow(() -> new ResourceNotFoundException("Category not found beta"));
        categoryRepository.delete(category);
    }
}




























