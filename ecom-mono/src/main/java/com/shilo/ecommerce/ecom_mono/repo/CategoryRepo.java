package com.shilo.ecommerce.ecom_mono.repo;

import com.shilo.ecommerce.ecom_mono.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category, Integer> {
}
