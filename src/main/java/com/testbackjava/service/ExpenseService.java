package com.testbackjava.service;

import java.text.ParseException;
import java.util.List;

import com.testbackjava.domain.Expense;

public interface ExpenseService {

    Expense saveExpense(Expense expense);
    List<Expense> getAllExpenses();
    List<Expense> findExpenseByDate(String date) throws ParseException;
    Expense addCategoryAutomatically (Expense expense);
}
