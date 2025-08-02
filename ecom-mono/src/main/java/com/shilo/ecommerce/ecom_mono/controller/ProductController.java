package com.shilo.ecommerce.ecom_mono.controller;

import com.shilo.ecommerce.ecom_mono.dto.ProductDTO;
import com.shilo.ecommerce.ecom_mono.model.Product;
import com.shilo.ecommerce.ecom_mono.response.CategoryResponse;
import com.shilo.ecommerce.ecom_mono.response.ProductResponse;
import com.shilo.ecommerce.ecom_mono.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping("/admin/categories/{categoryId}/product")
    public ResponseEntity<ProductDTO> addProduct(@RequestBody Product product,
                                                 @PathVariable int categoryId){
        ProductDTO productDTO = productService.addProduct(product, categoryId);
        return new ResponseEntity<>(productDTO, HttpStatus.CREATED);
    }

    @GetMapping("/public/products")
    public ResponseEntity<ProductResponse> getAllProducts(@RequestParam(name = "pageNum", defaultValue = "0") Integer pageNum,
                                                            @RequestParam(name = "pageSize", defaultValue = "0") Integer pageSize,
                                                            @RequestParam(name = "sortBy", defaultValue = "productId") String sortBy,
                                                            @RequestParam(name = "order", defaultValue = "asc") String order) {
        return new ResponseEntity<>(productService.getAllProducts(pageNum, pageSize, sortBy, order), HttpStatus.OK);
    }

    @GetMapping("/public/categories/{categoryId}/products")
    public ResponseEntity<ProductResponse> getProductsByCategory(@PathVariable int categoryId,
                                                                 @RequestParam(name = "pageNum", defaultValue = "0") Integer pageNum,
                                                                 @RequestParam(name = "pageSize", defaultValue = "0") Integer pageSize,
                                                                 @RequestParam(name = "sortBy", defaultValue = "productId") String sortBy,
                                                                 @RequestParam(name = "order", defaultValue = "asc") String order){
        return new ResponseEntity<>(productService.getProductsByCategory(categoryId, pageNum, pageSize, sortBy, order), HttpStatus.OK);

    }
    /*
    Get Product by category  /public/categories/{categoryId}/products

    Get products by keyword public/products/keyword/{keyword}

    */
}
