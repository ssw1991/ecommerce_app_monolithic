package com.shilo.ecommerce.ecom_mono.controller;

import com.shilo.ecommerce.ecom_mono.dto.ProductDTO;
import com.shilo.ecommerce.ecom_mono.response.ProductResponse;
import com.shilo.ecommerce.ecom_mono.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping("/admin/categories/{categoryId}/product")
    public ResponseEntity<ProductDTO> addProduct(@RequestBody ProductDTO product,
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

    @GetMapping("public/products/keyword/{keyword}")
    public ResponseEntity<ProductResponse> getProductsByKeyword(@PathVariable String keyword,
                                                                @RequestParam(name = "pageNum", defaultValue = "0") Integer pageNum,
                                                                @RequestParam(name = "pageSize", defaultValue = "0") Integer pageSize,
                                                                @RequestParam(name = "sortBy", defaultValue = "productId") String sortBy,
                                                                @RequestParam(name = "order", defaultValue = "asc") String order){
        return new ResponseEntity<>(productService.getProductsByKeyword(keyword, pageNum, pageSize, sortBy, order), HttpStatus.OK);
    }

    @PutMapping("/admin/products/{productId}")
    public ResponseEntity<ProductDTO> updateProduct(@RequestBody ProductDTO productDTO,
                                                         @PathVariable int productId) {
        ProductDTO savedProductDTO = productService.updateProduct(productDTO, productId);
        return new ResponseEntity<>(savedProductDTO, HttpStatus.OK);
    }

    @DeleteMapping("/admin/products/{productId}")
    public ResponseEntity<ProductDTO> deleteCategory(@PathVariable Integer productId){
        ProductDTO deletedProduct = productService.deleteProduct(productId);
        return new ResponseEntity<>(deletedProduct, HttpStatus.OK);
    }

    @PutMapping("/admin/products/{productId}/image")
    public ResponseEntity<ProductDTO> updateProductImage(@PathVariable int productId,
                                                         @RequestParam("image") MultipartFile image) throws IOException {
        ProductDTO updatedProduct = productService.updateProductImage(productId, image);
        return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
    }
}

