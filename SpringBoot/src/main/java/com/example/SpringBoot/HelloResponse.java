package com.example.SpringBoot;

public class HelloResponse {
    private String message;

    public HelloResponse(String helloWorld) {
        this.message = helloWorld;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
