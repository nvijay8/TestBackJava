package com.testbackjava.repository;

import org.springframework.data.repository.CrudRepository;

import com.testbackjava.domain.Category;

import java.util.List;

public interface CategoryRepository extends CrudRepository<Category, String> {
    List<Category> findByDescription(String description);
}
