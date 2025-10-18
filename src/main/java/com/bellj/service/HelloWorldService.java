package com.bellj.service;

import com.bellj.model.Request;
import jakarta.inject.Inject;

/**
 * HelloWorldService encapsulates the core business logic for generating a greeting.
 * It's designed to be injected by Dagger, making it modular, testable, and easy to extend.
 */
public class HelloWorldService {

    // Dependency on a formatter class that handles the actual string construction.
    private final GreetingFormatter formatter;

    /**
     * Constructor is annotated with @Inject, which tells Dagger:
     * "This is how you construct HelloWorldService."
     * Dagger will automatically resolve and inject GreetingFormatter when wiring the dependency graph.
     */
    @Inject
    public HelloWorldService(GreetingFormatter formatter) {
        this.formatter = formatter;
    }

    /**
     * Business method that takes a Request object and returns a formatted greeting.
     * Delegates the formatting logic to GreetingFormatter, keeping responsibilities separated.
     */
    public String greetUser(Request request) {
        return formatter.format(request);
    }
}