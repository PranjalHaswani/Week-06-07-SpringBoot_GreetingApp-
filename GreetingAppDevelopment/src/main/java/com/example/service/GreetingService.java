
package com.example.service;

import com.example.model.Greeting;
import com.example.repository.GreetingRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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

    // Add test data on startup
    @PostConstruct
    public void addTestData() {
        // Check if a greeting with ID 1 already exists; if not, add one
        if (!greetingRepository.existsById(1L)) {
            Greeting greeting = new Greeting("Hello, World!");
            greetingRepository.save(greeting); // Save the test data
        }
    }


    //UC6
    // Method to get all greetings
    public List<Greeting> getAllGreetings() {
        return greetingRepository.findAll();
    }

    //UC7
    public Greeting updateGreeting(Long id, String newMessage) {
        Optional<Greeting> greetingOpt = greetingRepository.findById(id);
        if (greetingOpt.isPresent()) {
            Greeting greeting = greetingOpt.get();
            greeting.setMessage(newMessage);
            return greetingRepository.save(greeting);
        }
        return null;
    }

    public void saveGreeting(Greeting greeting) {
        greetingRepository.save(greeting);
    }

    // UC8 - Method to delete a greeting by ID
    public boolean deleteGreeting(Long id) {
        // Check if the greeting exists
        Optional<Greeting> existingGreeting = greetingRepository.findById(id);

        if (existingGreeting.isPresent()) {
            greetingRepository.deleteById(id);  // Delete the greeting
            return true;
        }

        return false;
    }
}
