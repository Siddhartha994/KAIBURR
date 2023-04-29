# Use an official OpenJDK runtime as a parent image
FROM eclipse-temurin:17-jdk-jammy

# Set the working directory to /app
WORKDIR /KAIBURR

# Copy the application jar file to the container
COPY target/demo-0.0.1-SNAPSHOT.jar .

## Expose port 8080 for the container to listen on
#EXPOSE 8080

# Run the application when the container starts
ENTRYPOINT ["java", "-jar", "demo-0.0.1-SNAPSHOT.jar"]
