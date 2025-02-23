package com.example.Controller;

import com.example.model.Greeting;
import com.example.service.GreetingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/greet")
public class GreetingController {

    private final GreetingService greetingService;

    public GreetingController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    // GET method
    @GetMapping
    public Greeting getGreeting(@RequestParam(required = false) String firstName,
                                @RequestParam(required = false) String lastName) {
        return new Greeting(greetingService.getGreetingMessage(firstName, lastName));
    }

    // POST method
    @PostMapping
    public Greeting postGreeting(@RequestBody Greeting greeting) {
        // Return the greeting object sent in the request body
        return greeting;
    }

    // PUT method
    @PutMapping
    public Greeting putGreeting(@RequestBody Greeting greeting) {
        // Return updated greeting message
        return new Greeting("Updated: " + greeting.getMessage());
    }

    // DELETE method
    @DeleteMapping
    public Greeting deleteGreeting() {
        // Return confirmation that greeting is deleted
        return new Greeting("Greeting deleted");
    }
    //UC2

    @GetMapping("/hello")
    public Greeting getGreeting() {
        String greetingMessage = greetingService.getGreetingMessage();
        return new Greeting(greetingMessage);
    }

    //UC3
    // GET method to retrieve the greeting message
    @GetMapping("/hi")
    public Greeting getGreetingUC3(@RequestParam(required = false) String firstName,
                                   @RequestParam(required = false) String lastName){
        String greetingMessage = greetingService.getGreetingMessage(firstName, lastName);
        return new Greeting(greetingMessage);
    }

    //UC4
    // POST method to save the greeting message
    @PostMapping("/save")
    public Greeting saveGreeting(@RequestBody String message) {
        // Call the service to save the greeting message
        return greetingService.saveGreetingMessage(message);
    }

    //UC5
    // GET method to find a greeting by ID
    @GetMapping("/{id}")
    public Greeting getGreetingById(@PathVariable Long id) {
        // Call the service to find the greeting by ID and return it
        return greetingService.getGreetingById(id);
    }
    // Exception handler for Greeting not found
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handleGreetingNotFound(RuntimeException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    // GET method to list all greetings
    @GetMapping("/all")
    public List<Greeting> getAllGreetings() {
        return greetingService.getAllGreetings();
    }
}