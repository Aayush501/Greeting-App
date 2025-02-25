package com.greeting.restapis.sevices;

import com.greeting.restapis.dto.UserDTO;
import com.greeting.restapis.entities.Greeting;
import com.greeting.restapis.repository.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GreetingServices {
    private static final String template = "Hello, %s!";

    @Autowired
    private GreetingRepository greetingRepository;

    public Greeting getGreeting(UserDTO userDTO) {
        String name;
        if (userDTO.getFirstName() != null && userDTO.getLastName() != null) {
            name = userDTO.getFirstName() + " " + userDTO.getLastName();
        } else if (userDTO.getFirstName() != null) {
            name = userDTO.getFirstName();
        } else if (userDTO.getLastName() != null) {
            name = userDTO.getLastName();
        } else {
            name = "World";
        }
        return new Greeting(String.format(template, name));
    }
    public Greeting getGreetingById(Long id) {
        Optional<Greeting> greeting = greetingRepository.findById(id);
        return greeting.orElse(null); // Return the greeting if found, otherwise return null
    }
}