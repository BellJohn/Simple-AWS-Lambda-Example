package com.bellj.service;

import com.bellj.model.Request;
import jakarta.inject.Inject;

/**
 * GreetingFormatter is a simple utility class responsible for formatting a greeting message.
 * It demonstrates how Dagger can automatically inject classes using constructor injection,
 * without requiring an explicit @Provides method in a module.
 *
 * This class is different from Moshi or JsonAdapter, which are provided via @Provides in a module.
 * Instead, GreetingFormatter is discovered by Dagger because:
 *   - It has a public constructor annotated with @Inject
 *   - It's referenced by another injectable class (HelloWorldService)
 */
public class GreetingFormatter {

    /**
     * The @Inject constructor tells Dagger:
     * "You can construct this class directly—no module needed."
     * Dagger will automatically include it in the dependency graph if any other injectable depends on it.
     */
    @Inject
    public GreetingFormatter() {}

    /**
     * Formats a greeting string using the first name from the Request object.
     * This method encapsulates the string construction logic, allowing HelloWorldService
     * to delegate formatting and remain focused on orchestration.
     */
    public String format(Request request) {
        return String.format("Hello %s!", request.firstName());
    }
}