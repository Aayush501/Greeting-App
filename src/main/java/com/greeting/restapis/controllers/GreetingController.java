package com.greeting.restapis.controllers;

import com.greeting.restapis.entities.Greeting;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/greeting")
public class GreetingController {

    @GetMapping
    public Greeting getGreeting() {
        return new Greeting("Hello Aayush Kumar, this is a GET request!", HttpStatus.OK.value());
    }

    @PostMapping
    public Greeting postGreeting() {
        return new Greeting("Hello Aayush Kumar, this is a POST request!", HttpStatus.CREATED.value());
    }

    @PutMapping
    public Greeting putGreeting() {
        return new Greeting("Hello Aayush Kumar, this is a PUT request!", HttpStatus.OK.value());
    }

    @DeleteMapping
    public Greeting deleteGreeting() {
        return new Greeting("Hello Aayush Kumar, this is a DELETE request!", HttpStatus.NO_CONTENT.value());
    }
}