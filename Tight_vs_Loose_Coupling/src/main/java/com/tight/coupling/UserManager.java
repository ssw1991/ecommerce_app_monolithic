package com.tight.coupling;

public class UserManager {
    //
    private UserDatabase db = new UserDatabase();
    public String getUserInfo(){
        return db.getUserDetails();
    }
}
