package com.shilo.ecommerce.ecom_mono.service;

import com.shilo.ecommerce.ecom_mono.dto.CategoryDTO;
import com.shilo.ecommerce.ecom_mono.model.Category;
import com.shilo.ecommerce.ecom_mono.response.CategoryResponse;
import org.springframework.stereotype.Service;

@Service
public interface CategoryServiceI {

    CategoryResponse getAllCategories(Integer pageNum, Integer pageSize, String sortBy, String order);
    CategoryDTO createCategory(CategoryDTO categoryDTO);

    CategoryDTO deleteCategory(Integer categoryId);
    CategoryDTO updateCategory(CategoryDTO categoryDTO, Integer categoryId);
}
