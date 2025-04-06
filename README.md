# URL Shortener

A simple URL shortening service built with Spring Boot and MongoDB. This application generates tiny URLs using Base62 encoding and stores them in a MongoDB database. It currently supports a single-server setup.

## Features
- Shortens long URLs into compact, Base62-encoded tiny URLs.
- Stores URL mappings in MongoDB.
- Supports basic CRUD operations via REST endpoints.
- Runs MongoDB in a Docker container for easy setup.

## Tech Stack
- **App Name**: URL Shortener
- **Framework**: Spring Boot
- **Database**: MongoDB
- **Encoding**: Base62 (0-9, a-z, A-Z)
- **Containerization**: Docker (for MongoDB)

## Prerequisites
- Java 21+
- Gradle
- Docker
- Git

## Setup Instructions

### 1. Clone the Repository
```bash
git clone https://github.com/yourusername/url-shortener.git
cd url-shortener
```

### 2. Start a MongoDB instance in Docker on port 9090
```bash
docker run -d -p 9090:27017 --name mongo-container mongo
```
