package com.shilo.ecommerce.ecom_mono.service;

import com.shilo.ecommerce.ecom_mono.model.Category;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

@Service
public class CategoryServiceImpl implements CategoryServiceI {
    private Map<Integer, Category> categories = new HashMap<Integer, Category>();
    private Integer sequentialId = new Integer(0);

    @Override
    public List<Category> getAllCategories() {
        return new ArrayList<Category>(categories.values());
    }

    @Override
    public void createCategory(Category category) {
        Collection<Category> values = categories.values();
        for (Category cat : values) {
            if (cat.getCategoryName().equals( category.getCategoryName())) {
                throw new RuntimeException("Category Exists");
            }
        }

        Integer id = sequentialId++;
        category.setCategoryId(id);
        categories.put(id, category);
    }

    @Override
    public String deleteCategory(Integer categoryId) {
        categories.remove(categoryId);
        return "";
    }
}
