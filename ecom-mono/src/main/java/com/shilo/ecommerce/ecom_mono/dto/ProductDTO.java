package com.shilo.ecommerce.ecom_mono.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
    private int productId;
    private String productName;
    private String productDescription;
    private int quantity;
    private double price;
    private double specialPrice;
    private double discount;
    private String image;
    private CategoryDTO category;
}
