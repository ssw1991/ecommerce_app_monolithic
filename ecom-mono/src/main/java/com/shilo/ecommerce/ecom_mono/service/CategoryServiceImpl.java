package com.shilo.ecommerce.ecom_mono.service;

import com.shilo.ecommerce.ecom_mono.model.Category;
import com.shilo.ecommerce.ecom_mono.repo.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

@Service
public class CategoryServiceImpl implements CategoryServiceI {

    @Autowired
    CategoryRepo repo;

    @Override
    public List<Category> getAllCategories() {
        return repo.findAll();
    }


    @Override
    public void createCategory(Category category) {
       repo.save(category);
    }


    @Override
    public String deleteCategory(Integer categoryId) {
        repo.deleteById(categoryId);
        return "";
    }

    @Override
    public Category updateCategory(Category category, Integer categoryId){
        Category savedCategory = repo.findById(categoryId)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Category not found"));
        category.setCategoryId(categoryId);
        return repo.save(category);
    }
}
