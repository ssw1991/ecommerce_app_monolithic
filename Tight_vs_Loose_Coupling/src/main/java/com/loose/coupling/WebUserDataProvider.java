package com.loose.coupling;

public class WebUserDataProvider implements UserDataProvider{
    @Override
    public String getUserDetails() {
        return "From Web User Data Provider";
    }
}
