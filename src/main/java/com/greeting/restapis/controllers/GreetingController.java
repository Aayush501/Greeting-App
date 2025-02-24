package com.greeting.restapis.controllers;

import com.greeting.restapis.entities.GreetingRequest;
import com.greeting.restapis.entities.GreetingResponse;
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

    // Handle GET requests (Default Greeting)
    @GetMapping
    public GreetingResponse getDefaultGreeting() {
        return new GreetingResponse(greetingService.getGreetingMessage(null, null), 200);
    }

    // Handle POST requests (Personalized Greeting)
    @PostMapping
    public GreetingResponse createGreeting(@RequestBody GreetingRequest request) {
        String message = greetingService.getGreetingMessage(request.getFirstName(), request.getLastName());
        return new GreetingResponse(message, 201);
    }

    // Handles PUT requests
    @PutMapping
    public GreetingResponse putGreeting() {
        return new GreetingResponse(greetingService.putGreetingMessage(), HttpStatus.OK.value());
    }

    // Handles DELETE requests
    @DeleteMapping
    public GreetingResponse deleteGreeting() {
        return new GreetingResponse(greetingService.deleteGreetingMessage(), HttpStatus.NO_CONTENT.value());
    }
}