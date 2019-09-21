package com.testbackjava.repository;

import org.springframework.data.repository.CrudRepository;

import com.testbackjava.domain.Expense;

import java.util.Date;
import java.util.List;

public interface ExpenseRepository extends CrudRepository<Expense,String> {
    List<Expense> findByDate(Date date);

    List<Expense> findByUserCodeOrderByDateAsc(Long userCode);
}
