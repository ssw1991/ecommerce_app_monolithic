package com.example.annotation;

import com.example.annotation.config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Employee employee = context.getBean("employee", Employee.class);
        System.out.println(employee.toString());

        Manager manager = context.getBean("manager", Manager.class);
        System.out.println(manager.toString());
    }
}
