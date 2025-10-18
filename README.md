# Simple AWS Lambda Example with Dagger and Moshi

This project demonstrates how to build a modular, testable AWS Lambda function using:

- **Dagger** for compile-time dependency injection
- **Moshi** for JSON serialization/deserialization

It's intended to be minimal but demonstrates how you can hook together these different technologies to produce a simple Lambda workflow.

## Technologies Used
- Java 21
- Dagger
- Moshi
- AWS Lambda Java Core
- JUnit 5
- Gradle


## Deployment To AWS
If you want to deploy to AWS you will need to package this as a far JAR. Otherwise the relevant dependencies won't be present. 
Use the com.github.johnrengelman.shadow plugin to achieve this.

Deployment itself can be however suits, through the AWS console, CLI, etc.

## Testing
Don't take this as an example of good testing. It's not.



