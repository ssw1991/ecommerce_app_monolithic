package com.shilo.ecommerce.ecom_mono.model;

public class Category {
    private Integer categoryId;
    private String categoryName;

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setName(String name) {
        this.categoryName = name;
    }

    public Category(Integer categoryId, String name) {
        this.categoryId = categoryId;
        this.categoryName = name;
    }
}
