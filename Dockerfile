# Start with a base image containing Java runtime
FROM openjdk:21-jdk-slim

# Add the application's jar to the image
COPY target/tempo-0.0.1-SNAPSHOT.jar tempo-0.0.1-SNAPSHOT.jar

# Command to execute the application
ENTRYPOINT ["java", "-jar", "tempo-0.0.1-SNAPSHOT.jar"]