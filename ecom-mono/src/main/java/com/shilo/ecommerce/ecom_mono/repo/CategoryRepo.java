package com.shilo.ecommerce.ecom_mono.repo;

import com.shilo.ecommerce.ecom_mono.model.Category;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category, Integer> {
    Category findByCategoryName(String categoryName);
}
