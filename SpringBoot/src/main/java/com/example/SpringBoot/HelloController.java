package com.example.SpringBoot;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public HelloResponse hello(){
        return new HelloResponse("Hello World");
    }

    @GetMapping("/hello/{name}")
    public HelloResponse helloParam(@PathVariable String name){
        return new HelloResponse("Hello World " + name);
    }

    @PostMapping("/hello")
    public HelloResponse helloPost(@RequestBody HelloRequestBody body){
        // Using dedicated DTO
        return new HelloResponse("Hello " + body.getName());
    }

    @PostMapping("/hello2")
    public HelloResponse helloPost2(@RequestBody Map<String, Object> body){
        // With map instead of dedicated DTO
        return new HelloResponse("Hello " + body.get("name"));
    }

}
