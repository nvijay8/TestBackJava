package com.testbackjava.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.testbackjava.domain.Expense;
import com.testbackjava.service.CategoryService;
import com.testbackjava.service.ExpenseService;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/expense")
public class ExpenseController{


    @Autowired
    ExpenseService expenseService;
    @Autowired
    CategoryService categoryService;


    @PostMapping("/add")
    @PreAuthorize("hasRole('ADMIN')")
    public Expense addExpense(@RequestBody Expense expense)
    {
        return expenseService.saveExpense(expense);
    }
    
    @GetMapping("/findAll")
    @PreAuthorize("hasRole('ADMIN')")
    public List<Expense> getAllExpenses()
    {
        return expenseService.getAllExpenses();
    }

    @PostMapping("/addCategory")
    public Expense addCategoryAutomatically (@RequestBody Expense expense) {

        return expenseService.addCategoryAutomatically(expense);
    }    

    @GetMapping(value = "/find/{date}", produces = "application/json; charset=utf-8")
    public ResponseEntity<List<Expense>> findExpenseByDate(@PathVariable String date) throws ParseException {

        List<Expense> expenses = expenseService.findExpenseByDate(date);
        return ResponseEntity.status(HttpStatus.OK).body(expenses);
    }
    
  
}
