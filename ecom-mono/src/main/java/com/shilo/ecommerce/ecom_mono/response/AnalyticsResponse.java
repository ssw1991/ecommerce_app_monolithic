package com.shilo.ecommerce.ecom_mono.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnalyticsResponse {
    private String productCount;
    private String totalRevenue;
    private String totalOrders;
}
