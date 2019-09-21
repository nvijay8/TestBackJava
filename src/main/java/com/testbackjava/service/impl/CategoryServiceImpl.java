package com.testbackjava.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.testbackjava.domain.Category;
import com.testbackjava.repository.CategoryRepository;
import com.testbackjava.service.CategoryService;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service(value = "categoryService")
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public Category addCategory(Category request) {
        String id = UUID.randomUUID().toString();
        Category category = new Category(id,request.getDescription());
        return categoryRepository.save(category);
    }

    @Override
    public List<Category> searchCategoryByDescription(String searchCategory) {

        return categoryRepository.findByDescription(searchCategory);
    }
    
    @Override
    public List<Category> getAllCategory() {
        Iterable<Category> result = categoryRepository.findAll();
        List<Category> categoryList = new ArrayList<Category>();
        result.forEach(categoryList::add);
        return categoryList;
    }
}
