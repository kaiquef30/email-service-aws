# Microservice

## Overview
The Mail Service Microservice is a Java Spring Boot application designed for efficient and scalable email sending. It follows the principles of clean architecture to ensure modularity, testability, and maintainability. 
The project leverages JUnit and Mockito for comprehensive testing to guarantee the reliability of the implemented features.

## Features
- **Email Sending:** Seamlessly send emails using the microservice with customizable content and recipients.
- **Clean Architecture:** The project is structured following clean architecture principles, promoting separation of concerns and maintainability.
- **Java Spring Boot:** Utilizes the power of Spring Boot for rapid development, dependency injection, and easy configuration.
- **Testing with JUnit and Mockito:** Comprehensive unit tests ensure the robustness of the codebase, with Mockito for effective mocking.

## Technologies Used
- **Java Spring Boot:** A powerful framework for building Java-based enterprise applications.
- **JUnit:** A widely-used testing framework for Java applications.
- **Mockito:** A mocking framework for effective unit testing.
- **AWS SES (Simple Email Service):** Chosen as the email delivery service for reliable and scalable email sending.

## Project Structure
The project is organized based on the clean architecture principles, consisting of the following layers:
- **Use Cases:** Define application-specific use cases and business rules.
- **Adapters:** Implement the interfaces defined in the use cases layer and connect to external frameworks or libraries.
- **Frameworks & Drivers:** Contain the external frameworks, libraries, and delivery mechanisms such as web controllers.
