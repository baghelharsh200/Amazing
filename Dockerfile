# Use an official Java runtime as a parent image
FROM docker.io/library/openjdk:11-jre-slim


# Set the working directory in the container
WORKDIR /app

# Copy the built JAR file from the host to the container
COPY target/workers-backend.jar /app/workers-backend.jar

# Expose the port the app runs on
EXPOSE 8080

# Command to run the application
ENTRYPOINT ["java", "-jar", "workers-backend.jar"]
