package com.example.repository;

import com.example.model.Greeting;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GreetingRepository extends JpaRepository<Greeting, Long> {
    // You can add custom queries here if needed
}
