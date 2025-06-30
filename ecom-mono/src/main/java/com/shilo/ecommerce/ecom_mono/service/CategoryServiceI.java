package com.shilo.ecommerce.ecom_mono.service;

import com.shilo.ecommerce.ecom_mono.model.Category;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryServiceI {

    List<Category> getAllCategories();
    void createCategory(Category category);

    String deleteCategory(Integer categoryId);
    Category updateCategory(Category category, Integer categoryId);
}
