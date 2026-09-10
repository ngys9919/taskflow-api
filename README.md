<div align="center">

# TaskFlow API

[![Java 21](https://img.shields.io/badge/Java-21-orange?logo=java&logoColor=white)](https://www.oracle.com/java/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.1.1-brightgreen?logo=springboot&logoColor=white)](https://spring.io/projects/spring-boot)
[![Spring AI](https://img.shields.io/badge/Spring%20AI-OpenAI%20Integration-6A5ACD?logo=openai&logoColor=white)](https://spring.io/projects/spring-ai)
[![License](https://img.shields.io/badge/License-Unlicensed-lightgrey)](#)
[![Docker](https://img.shields.io/badge/Docker-Not%20Configured-blue?logo=docker&logoColor=white)](#)

**A lightweight task management API powered by Spring Boot and Spring AI.**

[Overview](#about-the-project) · [API Endpoints](#api-endpoints) · [Getting Started](#getting-started) · [Deployment](#deployment)

</div>

---

## About the Project

TaskFlow API is a RESTful task management backend built with Java and Spring Boot. It provides a simple in-memory task repository, full CRUD operations, and an AI-powered summary endpoint that uses Spring AI with OpenAI to generate a concise overview of outstanding and completed tasks.

This project is designed for learning, prototyping, and extension. It is a clean backend foundation for a future front end, workflow dashboard, or productivity application.

### Key Features

- CRUD operations for tasks
- In-memory task persistence for local development
- AI-generated task summary using OpenAI and Spring AI
- Lightweight Java 21 Spring Boot architecture
- Easy REST integration with JSON payloads
- Prepared for extension to a persistent database and UI layer

### Project Highlights

- Backend framework: Spring Boot 4.1.1
- Language: Java 21
- AI integration: Spring AI + OpenAI
- API style: RESTful JSON
- Data model: in-memory repository with seeded sample tasks

---

## Tech Stack

| Category | Technology |
|---|---|
| Language | Java 21 |
| Framework | Spring Boot 4.1.1 |
| Web | Spring Web MVC |
| AI / LLM | Spring AI, OpenAI GPT-4o-mini |
| Build Tool | Maven |
| Environment Config | `.env` / `application.properties` |
| Testing | Spring Boot Test |
| Dev Workflow | Spring Boot DevTools |

---

## Architecture

```text
+----------------------+
| Client / Frontend    |
| Browser / Postman    |
+----------+-----------+
           |
           v
+----------------------+
| REST API Layer       |
| TaskController       |
| GET/POST/PUT/DELETE  |
+----------+-----------+
           |
           v
+----------------------+
| Service Layer        |
| TaskService          |
+----------+-----------+
           |
           v
+----------------------+
| Repository Layer     |
| TaskRepository       |
| In-memory store      |
+----------+-----------+
           |
           v
+----------------------+
| AI Integration       |
| Spring AI + OpenAI   |
| /api/tasks/summary  |
+----------------------+
```

---

## API Endpoints

The API is available under the base path `/api/tasks`.

| Method | Endpoint | Description |
|---|---|---|
| GET | `/api/tasks` | Get all tasks |
| GET | `/api/tasks/{id}` | Get a task by ID |
| POST | `/api/tasks` | Create a new task |
| PUT | `/api/tasks/{id}` | Update a task |
| DELETE | `/api/tasks/{id}` | Delete a task |
| PUT | `/api/tasks/{id}/complete` | Mark a task as complete |
| GET | `/api/tasks/summary` | Generate a plain-English summary of all tasks via OpenAI |

### Example Task Model

```json
{
  "id": 123456789,
  "title": "Build login page",
  "description": "Create a login form with email and password fields and basic validation.",
  "priority": "high",
  "isCompleted": false
}
```

---

## Project Structure

```text
taskflow-api/
├── .env.example
├── .gitignore
├── HELP.md
├── mvnw
├── mvnw.cmd
├── pom.xml
├── README.md
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── sg/
│   │   │       └── edu/
│   │   │           └── ntu/
│   │   │               └── taskflow_api/
│   │   │                   ├── TaskflowApiApplication.java
│   │   │                   ├── controller/
│   │   │                   │   └── TaskController.java
│   │   │                   ├── model/
│   │   │                   │   └── Task.java
│   │   │                   ├── repository/
│   │   │                   │   └── TaskRepository.java
│   │   │                   └── service/
│   │   │                       └── TaskService.java
│   │   └── resources/
│   │       └── application.properties
│   └── test/
│       └── java/
│           └── sg/
│               └── edu/
│                   └── ntu/
│                       └── taskflow_api/
│                           └── TaskflowApiApplicationTests.java
└── target/
```

---

## Getting Started

### Prerequisites

Before running the project, make sure you have:

- Java 21 or later
- Maven 3.9+
- An OpenAI API key
- Optional: Docker if you want container-based deployment later

### 1. Clone the Repository

```bash
git clone https://github.com/ngys9919/taskflow-api.git
cd taskflow-api
```

### 2. Configure Environment Variables

Copy the example environment file and add your key:

```bash
cp .env.example .env
```

Then update `.env`:

```env
OPENAI_API_KEY=your_openai_api_key_here
```

The application loads this value in `src/main/resources/application.properties`.

### 3. Install Dependencies

```bash
./mvnw install
```

### 4. Run the Application

```bash
./mvnw spring-boot:run
```

The server should start on the default Spring Boot port:

- http://localhost:8080

### 5. Test the API

Example request:

```bash
curl http://localhost:8080/api/tasks
```

Example summary request:

```bash
curl http://localhost:8080/api/tasks/summary
```

---

## Deployment

This project is currently configured for local development and can be adapted for cloud deployment.

### Docker

A Dockerfile is not included in the current project, but you can add one for container deployment.

```bash
docker build -t taskflow-api .
docker run -p 8080:8080 --env-file .env taskflow-api
```

### Platform Recommendations

- Render
- Railway
- Fly.io
- Azure App Service
- AWS Elastic Beanstalk

For cloud deployment, make sure to set the `OPENAI_API_KEY` environment variable in the hosting platform.

---

## Contributing

Contributions are welcome.

1. Fork the repository.
2. Create a feature branch:
   ```bash
   git checkout -b feature/your-feature-name
   ```
3. Commit your changes:
   ```bash
   git commit -m "Add your feature"
   ```
4. Push to your branch:
   ```bash
   git push origin feature/your-feature-name
   ```
5. Open a pull request for review.

For questions or feature requests, open an issue or discussion in the repository.

---

## Developed By

>> Coder: **Ng Yew Seng (353F)**

>> NTU SCTP AI Engineering

>> for Module 3: Backend Server-Side Development

>> © Copyright 2026

---

## Acknowledgements

This project was created as a Spring Boot learning and API prototyping exercise.

Special thanks to:

- Spring Boot documentation and community
- Spring AI project contributors
- OpenAI for accessible AI model integration
- The NTU/academic project team for the taskflow use case and project direction

---

## Call to Action

If you find this project useful, please star the repository and share it with others.

> Better workflows start with cleaner APIs.

