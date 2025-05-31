package com.example.annotation.config;

import com.example.annotation.Employee;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.example.annotation")
public class AppConfig {

    @Bean
    public Employee employee1() {
        Employee emp = new Employee();
        emp.setFirstName("John");
        emp.setLastName("Smith");
        emp.setSalary(5000);
        emp.setEmployeeId(1);
        return emp;
    }
}
