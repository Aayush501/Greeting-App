package com.greeting.restapis.services;

import com.greeting.restapis.dto.UserDTO;
import com.greeting.restapis.entities.Greeting;
import com.greeting.restapis.repository.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
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
        Greeting newGreeting = new Greeting(String.format(template, name));
        greetingRepository.save(newGreeting);
        return newGreeting;
    }
    public Greeting getGreetingById(Long id) {
        Optional<Greeting> greeting = greetingRepository.findById(id);
        return greeting.orElse(null); // Return the greeting if found, otherwise return null
    }
    public List<Greeting> getAllGreetings() {
        return greetingRepository.findAll();
    }

    public Greeting editGreeting(String content, Greeting updatedGreeting) {
        Optional<Greeting> existingGreeting = greetingRepository.findByContentLikeIgnoreCase(content);
        if (existingGreeting.isPresent()) {
            Greeting greeting = existingGreeting.get();
            greeting.setContent(updatedGreeting.getContent());
            greetingRepository.save(greeting);
            return greeting;
        } else {
            return null; // Or throw an exception if preferred
        }
    }

    @Transactional
    public List<Greeting> deleteOne(String content) {
        greetingRepository.deleteByContentLikeIgnoreCase(content);
        return getAllGreetings();
    }
}