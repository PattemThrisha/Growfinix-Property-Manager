# Simple Java HTTP Server (Task 5)

## Description
This project demonstrates how a basic web server works using Java's built-in HttpServer. It listens on a specific port and handles HTTP GET and POST requests.

## Tech Stack
Java  
HttpServer  

## Features
Handles HTTP GET requests  
Handles HTTP POST requests  
Parses request body data  
Returns JSON responses  
Runs on localhost server  

## Endpoints

GET /hello  
Returns a simple JSON message  

POST /data  
Accepts data and returns it as a response  

## How to Run

Compile:
javac SimpleHttpServer.java

Run:
java SimpleHttpServer

Open in browser:
http://localhost:8080/hello

## Output
Displays JSON response for GET request  
Handles POST request and returns received data  

## Learning Outcome
Learned how web servers work at a low level, handling HTTP requests and responses without using frameworks like Spring Boot.
