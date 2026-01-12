package com.shilo.ecommerce.ecom_mono.security.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.Set;

@Data
public class SignupRequest {

    @NotBlank
    private String username;

    @NotBlank
    @Email
    private String email;


    private Set<String> roles;

    @NotBlank
    private String password;
}
