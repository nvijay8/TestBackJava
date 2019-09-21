package com.testbackjava.service;

import java.util.List;

import com.testbackjava.domain.Category;
import com.testbackjava.domain.Expense;

public interface CategoryService {

    Category addCategory(Category request);
    List<Category> getAllCategory();
    List<Category> searchCategoryByDescription(String searchCategory);
}
