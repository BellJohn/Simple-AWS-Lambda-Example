package com.bellj.model;

/**
 * Request is a simple data model representing the incoming payload to your Lambda function.
 * It's defined as a Java record, which is a compact syntax for immutable data carriers introduced in Java 14.
 *
 * This record has a single field:
 *   - firstName: the name of the user to be greeted
 *
 * Benefits of using a record:
 *   - Automatically generates constructor, getter, equals(), hashCode(), and toString()
 *   - Immutable by default, making it safe for concurrent and stateless environments like AWS Lambda
 *   - Clean and expressive syntax, ideal for modeling JSON-bound request objects
 *
 * This class is used by Moshi to deserialize the incoming JSON string into a strongly typed Request object.
 * Example input JSON:
 *   { "firstName": "John" }
 *
 * Once deserialized, the Request object is passed to HelloWorldService for greeting generation.
 */
public record Request(String firstName) {}