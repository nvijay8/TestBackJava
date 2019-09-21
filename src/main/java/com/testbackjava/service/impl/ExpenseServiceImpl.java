package com.testbackjava.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.testbackjava.domain.Category;
import com.testbackjava.domain.Expense;
import com.testbackjava.repository.CategoryRepository;
import com.testbackjava.repository.ExpenseRepository;
import com.testbackjava.service.ExpenseService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service(value = "expenseService")
public class ExpenseServiceImpl implements ExpenseService {

    @Autowired
    ExpenseRepository expenseRepository;
    @Autowired
    CategoryRepository categoryRepository;


    public Expense saveExpense(Expense expense) {
        String id = UUID.randomUUID().toString();
        Expense exp = new Expense(id, expense.getDescription(), expense.getValue(), expense.getAlias(), expense.getDate(), expense.getCategory());
        expenseRepository.save(exp);
        return exp;
    }

    @Override
    public List<Expense> getAllExpenses() {
        Iterable<Expense> result = expenseRepository.findAll();
        List<Expense> employeesList = new ArrayList<Expense>();
        result.forEach(employeesList::add);
        return employeesList;
    }

    @Override
    public List<Expense> findExpenseByDate(String date) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date datep = sdf.parse(date);

        return expenseRepository.findByDate(datep);
    }

    @Override
    public Expense addCategoryAutomatically(Expense expense) {
        List<Category> categories = categoryRepository.findByDescription(expense.getCategory().getDescription());
        if (categories.size()>0){
            expense.setCategory(categories.get(0));
        }

        return expenseRepository.save(expense);
    }
}
