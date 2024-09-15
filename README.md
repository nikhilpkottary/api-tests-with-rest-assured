# API Testing with Rest-Assured
This repository demonstrates how to automate API testing using Rest-Assured, focusing on parameterization, request/response specifications reuse, and object serialization.

# Requirements
* JDK 11 or higher
* Maven (for dependency management and build)

# API Used for Demonstration
* REQRES API: https://reqres.in/

# Scenarios Covered
* Parameterizing Rest-Assured Test Cases with Data Provider: Implemented to run tests with multiple sets of data, improving test coverage and re-usability.
* Reuse Request and Response Specifications: Optimized API test cases by using predefined request and response specifications to eliminate code duplication.
* Serializing a Java Object to a JSON Request Body: Demonstrates converting Java objects to JSON format and sending them in the request body for API testing.

# Project Structure
* src/main/java: Contains POJO's and configuration class.
* src/test/java: Contains the Rest-Assured test classes, test data provider, and configurations for request and response specifications.

# Features
* Parameterized API tests using TestNG Data Providers.
* Re-usability through Request and Response Specification.
* POJO Serialization for sending structured data in requests.