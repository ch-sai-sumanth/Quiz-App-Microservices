# Quiz App


The **Quiz Application** is a scalable solution built using **Spring Boot** and a **microservices architecture**. It consists of two microservices: **Question** and **Quiz**, both registered with **Eureka** for service discovery. An **API Gateway** handles unified access to the microservices, while **OpenFeign** enables efficient communication between services.

## Key Features

- **Microservices Architecture**: Modular services for handling questions and quizzes.
- **Eureka for Service Discovery**: Dynamically discovers and registers microservices.
- **API Gateway**: Unified access to the microservices via a single port.
- **OpenFeign**: Enables communication between microservices in an efficient way.

## Tech Stack

- **Java**
- **Spring Boot**
- **Microservices**
- **Eureka Server/Client**
- **API Gateway**
- **OpenFeign**

## How to Run

1. Clone the repository:
    ```bash
    git clone [GitHub Link]
    ```
2. Navigate to the project directory:
    ```bash
    cd quiz-app
    ```
3. Start the Eureka server:
    ```bash
    ./mvnw spring-boot:run -pl eureka-server
    ```
4. Start the API Gateway and microservices:
    ```bash
    ./mvnw spring-boot:run -pl api-gateway
    ./mvnw spring-boot:run -pl quiz-service
    ./mvnw spring-boot:run -pl question-service
    ```
