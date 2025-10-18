package com.bellj;

// AWS Lambda runtime interfaces
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

// Your custom handler logic
import com.bellj.handler.Handler;

// Dagger-generated component that wires dependencies
import com.bellj.config.DaggerConfig;

/**
 * LambdaEntryPoint is the entry class for AWS Lambda execution.
 * It implements RequestHandler<String, String>, meaning it accepts a raw JSON string as input
 * and returns a string as output—ideal for simple demos or API Gateway integrations.
 */
public class LambdaEntryPoint implements RequestHandler<String, String> {

    // The actual business logic handler, injected via Dagger
    private final Handler handler;

    /**
     * Constructor is invoked once per cold start.
     * It initializes the Dagger dependency graph by calling DaggerConfig.create(),
     * which is a compile-time generated class based on your @Component interface.
     * This wires together all dependencies (e.g., Moshi, HelloWorldService) and provides a fully constructed Handler.
     */
    public LambdaEntryPoint() {
        this.handler = DaggerConfig.create().handler();
    }

    /**
     * This method is called by the AWS Lambda runtime for each invocation.
     * It delegates the request to the injected Handler, passing along the input JSON and Lambda context.
     * The Handler is responsible for parsing the input, executing business logic, and returning a response.
     */
    @Override
    public String handleRequest(String input, Context context) {
        return handler.handleRequest(input, context);
    }
}