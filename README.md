# Time to Words Converter

This is a Spring Boot application that converts time into words. It provides an API to convert the time into words when we enter input in "HH:mm" format.

## Features

- Convert the current time to words.
- Accept user input in "HH:mm" format and return the corresponding time in words.

## Setup Instructions

1. Clone the repository:
2. Navigate to the project directory:
3. Build all projects using Maven: mvn clean install
4. Run all applications


## Usage

- Time-To-Words-Request-Repo project(port=8082) for to validate input and to send the request to
  Time-To-Words-Response-Repo(port=8083)  service 
  --- To convert a specific time, send a post request to `http://localhost:8082/gettimeinword?     time=HH:mm`, replacing `HH:mm` with the desired time.
  --- use URL to test api http://localhost:8082/swagger-ui/index.html
- Time-To-Words-Response-Repo  project for to process request 
- Service-Registry port 9761
- api-gateway port 8084



## Example

- Current time: `14:30` -> Response: "It's two thirty."
- User input: `12:00` -> Response: "It's Midday."
- User input: `00:00` -> Response: "It's Midnight."

## Dependencies

This project uses Spring Boot and other necessary libraries defined in the `pom.xml` file. Make sure to check the file for any additional dependencies required for your setup.