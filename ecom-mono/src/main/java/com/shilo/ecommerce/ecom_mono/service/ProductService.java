package com.shilo.ecommerce.ecom_mono.service;

import com.shilo.ecommerce.ecom_mono.dto.ProductDTO;
import com.shilo.ecommerce.ecom_mono.model.Product;
import com.shilo.ecommerce.ecom_mono.response.ProductResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public interface ProductService {
    ProductDTO addProduct(ProductDTO productDTO, int categoryId);

    ProductResponse getAllProducts(Integer pageNum, Integer pageSize, String sortBy, String order);

    ProductResponse getProductsByCategory(int categoryId, Integer pageNum, Integer pageSize, String sortBy, String order);

    ProductResponse getProductsByKeyword(String keyword, Integer pageNum, Integer pageSize, String sortBy, String order);

    ProductDTO updateProduct(ProductDTO productDTO, int productId);

    ProductDTO deleteProduct(Integer productId);

    ProductDTO updateProductImage(int productId, MultipartFile image) throws IOException;
}
