package com.shilo.ecommerce.ecom_mono.service;

import com.shilo.ecommerce.ecom_mono.repo.OrderRepo;
import com.shilo.ecommerce.ecom_mono.repo.ProductRepo;
import com.shilo.ecommerce.ecom_mono.response.AnalyticsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnalyticsServiceImpl implements AnalyticsService{

    @Autowired
    private ProductRepo productRepository;

    @Autowired
    private OrderRepo orderRepository;

    @Override
    public AnalyticsResponse getAnalyticsData() {
        AnalyticsResponse response = new AnalyticsResponse();

        long productCount = productRepository.count();
        long totalOrders = orderRepository.count();;
        Double totalRevenue = orderRepository.getTotalRevenue();

        response.setProductCount(String.valueOf(productCount));
        response.setTotalOrders(String.valueOf(totalOrders));
        response.setTotalRevenue(String.valueOf(totalRevenue != null ? totalRevenue : 0));
        return response;
    }
}