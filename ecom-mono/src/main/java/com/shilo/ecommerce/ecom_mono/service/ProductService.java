package com.shilo.ecommerce.ecom_mono.service;

import com.shilo.ecommerce.ecom_mono.dto.ProductDTO;
import com.shilo.ecommerce.ecom_mono.model.Product;
import com.shilo.ecommerce.ecom_mono.response.ProductResponse;
import org.springframework.stereotype.Service;

@Service
public interface ProductService {
    ProductDTO addProduct(Product product, int categoryId);

    ProductResponse getAllProducts(Integer pageNum, Integer pageSize, String sortBy, String order);

    ProductResponse getProductsByCategory(int categoryId, Integer pageNum, Integer pageSize, String sortBy, String order);
}
