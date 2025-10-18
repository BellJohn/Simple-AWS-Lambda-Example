package com.bellj;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LambdaEntryPointTest {

    private static final String inputJson = """
            {
            "firstName":"John"
            }
            """;


    /**
     * This just proves the lambda hangs together, all the dagger magic is working
     * and the moshi config is able to marshall our POJO
     */
    @Test
    void test() {
        LambdaEntryPoint lambdaEntryPoint = new LambdaEntryPoint();
        String response = lambdaEntryPoint.handleRequest(inputJson, null);
        assertEquals("Hello John!", response);
    }
}
