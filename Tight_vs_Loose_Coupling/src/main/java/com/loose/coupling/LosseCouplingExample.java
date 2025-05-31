package com.loose.coupling;

public class LosseCouplingExample {

    public static void main(String[] args) {

        /* This demonstrates how with loose coupling we can change the database
           without changing the user manager.  The user manager's internal database provider
           was dynamically assigned, so changing DB requirements did not require any code change
           on the user manager.  Simple example, can also be accomplished with Abstract class instead
           of interface.
        */

        UserDataProvider up = new UserDatabaseProvider();
        UserManager um = new UserManager(up);
        System.out.println(um.getUserInfo());

        UserDataProvider wb = new WebUserDataProvider();
        UserManager umw = new UserManager(wb);
        System.out.println(umw.getUserInfo());
    }
}
