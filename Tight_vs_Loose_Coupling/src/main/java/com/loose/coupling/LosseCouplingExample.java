package com.loose.coupling;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LosseCouplingExample {

    public static void main(String[] args) {

        /* This demonstrates how with loose coupling we can change the database
           without changing the user manager.  The user manager's internal database provider
           was dynamically assigned, so changing DB requirements did not require any code change
           on the user manager.  Simple example, can also be accomplished with Abstract class instead
           of interface.
        */
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        UserManager userManager = (UserManager) context.getBean("userManager");
        System.out.println(userManager.getUserInfo());

        UserManager webUserManager = (UserManager) context.getBean("webUserManager");
        System.out.println(webUserManager.getUserInfo());
    }
}
