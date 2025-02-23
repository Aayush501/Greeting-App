package com.greeting.restapis.controllers;

import com.greeting.restapis.entities.Greeting;
import com.greeting.restapis.sevices.GreetingServices;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/greeting") // Base URL for all endpoints
public class GreetingController {

    private final GreetingServices greetingService;

    public GreetingController(GreetingServices greetingService) {
        this.greetingService = greetingService;
    }

    // Handles GET requests
    @GetMapping
    public Greeting getGreeting() {
        return new Greeting(greetingService.getGreetingMessage(), HttpStatus.OK.value());
    }

    // Handles POST requests
    @PostMapping
    public Greeting postGreeting() {
        return new Greeting(greetingService.postGreetingMessage(), HttpStatus.CREATED.value());
    }

    // Handles PUT requests
    @PutMapping
    public Greeting putGreeting() {
        return new Greeting(greetingService.putGreetingMessage(), HttpStatus.OK.value());
    }

    // Handles DELETE requests
    @DeleteMapping
    public Greeting deleteGreeting() {
        return new Greeting(greetingService.deleteGreetingMessage(), HttpStatus.NO_CONTENT.value());
    }
}