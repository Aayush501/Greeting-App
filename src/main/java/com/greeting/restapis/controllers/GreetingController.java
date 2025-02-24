package com.greeting.restapis.controllers;

import com.greeting.restapis.dto.UserDTO;
import com.greeting.restapis.entities.Greeting;

import com.greeting.restapis.sevices.GreetingServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

    @Autowired
    private GreetingServices greetingService;

    // Handles GET requests to /greeting
    @GetMapping
    public Greeting getGreeting(@RequestParam(required = false) String firstName,
                                @RequestParam(required = false) String lastName) {
        UserDTO userDTO = new UserDTO();
        userDTO.setFirstName(firstName);
        userDTO.setLastName(lastName);
        return greetingService.getGreeting(userDTO);
    }
}