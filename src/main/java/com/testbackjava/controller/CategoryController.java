package com.testbackjava.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.testbackjava.domain.Category;
import com.testbackjava.domain.Expense;
import com.testbackjava.service.CategoryService;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {


    @Autowired
    CategoryService categoryService;

    @PostMapping("/add")
    public Category addCategory(@RequestBody Category request){
        return categoryService.addCategory(request);
    }

    @GetMapping("/findAll")
    public List<Category> getAllExpenses()
    {
        return categoryService.getAllCategory();
    }

}
