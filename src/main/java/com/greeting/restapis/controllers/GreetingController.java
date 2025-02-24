package com.greeting.restapis.controllers;

import com.greeting.restapis.entities.GreetingMessage;
import com.greeting.restapis.entities.GreetingRequest;
import com.greeting.restapis.entities.GreetingResponse;
import com.greeting.restapis.sevices.GreetingServices;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/greeting") // Base URL for all endpoints
public class GreetingController {


    private final GreetingServices greetingService;

    public GreetingController(GreetingServices greetingService) {
        this.greetingService = greetingService;
    }

    // Create and Save Greeting
    @PostMapping
    public GreetingResponse createGreeting(@RequestBody GreetingRequest request) {
        return greetingService.generateAndSaveGreeting(request);
    }

    // Fetch All Saved Greetings
    @GetMapping("/all")
    public List<GreetingMessage> getAllGreetings() {
        return greetingService.getAllGreetings();
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