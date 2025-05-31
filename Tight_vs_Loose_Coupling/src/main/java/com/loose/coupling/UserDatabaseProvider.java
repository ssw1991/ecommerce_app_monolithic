package com.loose.coupling;

public class UserDatabaseProvider implements UserDataProvider{
    // All the code to interact with DB (dummy)

   @Override
   public String getUserDetails(){
        return "User details from DB, loose coupling";
    }
}
