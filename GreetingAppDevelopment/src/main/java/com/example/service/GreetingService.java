package com.example.service;

import com.example.model.Greeting;
import com.example.repository.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GreetingService {

    private final GreetingRepository greetingRepository;

    // Constructor Injection for GreetingRepository
    @Autowired
    public GreetingService(GreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository; // Properly injecting the repository
    }

    public String getGreetingMessage(String firstName, String lastName) {
        if (firstName != null && lastName != null) {
            return "Hello " + firstName + " " + lastName;
        } else if (firstName != null) {
            return "Hello " + firstName;
        } else if (lastName != null) {
            return "Hello " + lastName;
        } else {
            return "Hello World";
        }
    }

    //UC2
    public String getGreetingMessage() {
        return "Hello World";
    }

    //UC4
    // Method to save greeting message
    public Greeting saveGreetingMessage(String message) {
        Greeting greeting = new Greeting(message);
        return greetingRepository.save(greeting);
    }

    // Method to find a Greeting by ID
    public Greeting getGreetingById(Long id) {
        Optional<Greeting> greetingOptional = greetingRepository.findById(id);
        return greetingOptional.orElseThrow(() -> new RuntimeException("Greeting not found with ID " + id));
    }

}