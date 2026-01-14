package com.shilo.ecommerce.ecom_mono.dto;

import com.shilo.ecommerce.ecom_mono.model.Address;
import lombok.Data;

import java.util.Map;

@Data
public class StripePaymentDTO {
    private Integer amount;
    private String currency;
    private String email;
    private String name;
    private Address address;
    private String description;
    private Map<String, String> metadata;
}
