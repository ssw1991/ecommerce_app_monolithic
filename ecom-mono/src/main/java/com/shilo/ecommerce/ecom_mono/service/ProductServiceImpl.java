package com.shilo.ecommerce.ecom_mono.service;

import com.shilo.ecommerce.ecom_mono.dto.CategoryDTO;
import com.shilo.ecommerce.ecom_mono.dto.ProductDTO;
import com.shilo.ecommerce.ecom_mono.exceptions.ResourceNotFoundException;
import com.shilo.ecommerce.ecom_mono.model.Category;
import com.shilo.ecommerce.ecom_mono.model.Product;
import com.shilo.ecommerce.ecom_mono.repo.CategoryRepo;
import com.shilo.ecommerce.ecom_mono.repo.ProductRepo;
import com.shilo.ecommerce.ecom_mono.response.CategoryResponse;
import com.shilo.ecommerce.ecom_mono.response.ProductResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private CategoryRepo categoryRepo;
    @Autowired
    private ProductRepo productRepo;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ProductDTO addProduct(Product product, int categoryId) {
        Category category = categoryRepo.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category","categoryId",categoryId));
        product.setImage("default.png");
        product.setCategory(category);
        double specialPrice = product.getPrice()*(1 -product.getDiscount()*.01);
        product.setSpecialPrice(specialPrice);
        Product savedProduct = productRepo.save(product);
        return modelMapper.map(savedProduct, ProductDTO.class);
    }

    @Override
    public ProductResponse getAllProducts(Integer pageNum, Integer pageSize, String sortBy, String order) {
        Sort sortDetails = order.equalsIgnoreCase("asc")
                ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();

        Pageable pageable = PageRequest.of(pageNum, pageSize, sortDetails);
        Page<Product> page = productRepo.findAll(pageable);
        List<Product> products = page.getContent();


        List<ProductDTO> productDTOS = products.stream()
                .map(product -> modelMapper.map(product, ProductDTO.class))
                .toList();
        ProductResponse productResponse = new ProductResponse(productDTOS,
                page.getNumber(),
                page.getSize(),
                page.getTotalElements(),
                page.getTotalPages(),
                page.isLast()
        );
        productResponse.setContent(productDTOS);
        return productResponse;
    }

    @Override
    public ProductResponse getProductsByCategory(int categoryId, Integer pageNum, Integer pageSize, String sortBy, String order) {
        Category category = categoryRepo.getById(categoryId);
        Sort sortDetails = order.equalsIgnoreCase("asc")
                ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();

        Pageable pageable = PageRequest.of(pageNum, pageSize, sortDetails);
        Page<Product> page = productRepo.findByCategory(category, pageable);
        List<Product> products = page.getContent();


        List<ProductDTO> productDTOS = products.stream()
                .map(product -> modelMapper.map(product, ProductDTO.class))
                .toList();
        ProductResponse productResponse = new ProductResponse(productDTOS,
                page.getNumber(),
                page.getSize(),
                page.getTotalElements(),
                page.getTotalPages(),
                page.isLast()
        );
        productResponse.setContent(productDTOS);
        return productResponse;
    }
}
