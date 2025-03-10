package com.greeting.restapis.controllers;

import com.greeting.restapis.dto.UserDTO;
import com.greeting.restapis.entities.Greeting;
import com.greeting.restapis.services.GreetingServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    // Handles GET requests to /greeting/{id}
    @GetMapping("/{id}")
    public Greeting getGreetingById(@PathVariable Long id) {
        return greetingService.getGreetingById(id);
    }

    @GetMapping("/all")
    public List<Greeting> getAllGreetings() {
        return greetingService.getAllGreetings();
    }

    @PutMapping("/update/{content}")
    public Greeting editGreeting(@PathVariable String content, @RequestBody Greeting greeting) {
        return greetingService.editGreeting(content, greeting);
    }

    @DeleteMapping("/delete/{content}")
    public List<Greeting> deleteGreeting(@PathVariable String content) {
        return greetingService.deleteOne(content);
    }
}