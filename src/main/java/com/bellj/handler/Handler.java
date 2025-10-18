package com.bellj.handler;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.bellj.model.Request;
import com.bellj.service.HelloWorldService;
import com.squareup.moshi.JsonAdapter;

import java.io.IOException;

/**
 * Handler is the core logic class for your Lambda function.
 * It implements AWS's RequestHandler interface, meaning it can be invoked directly by the Lambda runtime.
 *
 * Unlike LambdaEntryPoint, which wires dependencies, this class focuses purely on:
 *   - Deserializing the input JSON
 *   - Executing business logic
 *   - Returning a response
 *
 * This separation of concerns makes the system more testable and modular.
 */
public class Handler implements RequestHandler<String, String> {

    // Moshi adapter for converting raw JSON into a strongly typed Request object
    private final JsonAdapter<Request> requestJsonAdapter;

    // Business logic service that generates a greeting
    private final HelloWorldService helloWorldService;

    /**
     * Constructor receives dependencies via Dagger injection.
     * These are wired in your Dagger component and passed into this class automatically.
     * This design keeps the handler stateless and easy to test.
     */
    public Handler(JsonAdapter<Request> requestJsonAdapter, HelloWorldService helloWorldService){
        this.requestJsonAdapter = requestJsonAdapter;
        this.helloWorldService = helloWorldService;
    }

    /**
     * This method is called by the Lambda runtime for each invocation.
     * It performs three key steps:
     *   1. Deserialize the input JSON string into a Request object using Moshi
     *   2. Pass the Request to HelloWorldService to generate a greeting
     *   3. Return the greeting string as the Lambda response
     *
     * If deserialization fails, it throws a RuntimeException to signal an error.
     */
    @Override
    public String handleRequest(String input, Context context) {
        try {
            Request request = requestJsonAdapter.fromJson(input);
            return helloWorldService.greetUser(request);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}