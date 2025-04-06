# Use Amazon Corretto 21 as base image
FROM amazoncorretto:21

# Set working directory inside the container
WORKDIR /app

# Copy the built Spring Boot JAR into the container
COPY build/libs/urlshortener-0.0.1-SNAPSHOT.jar app.jar

# Expose the port your Spring Boot app runs on
EXPOSE 8080

# Start the application
ENTRYPOINT ["java", "-jar", "app.jar"]
