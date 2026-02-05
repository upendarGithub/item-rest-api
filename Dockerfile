# Use Java 17
FROM eclipse-temurin:17-jdk

# Set working directory
WORKDIR /app

# Copy Maven build files
COPY pom.xml .
COPY src ./src

# Build the application
RUN ./mvnw package || mvn clean package

# Run the app
CMD ["java", "-jar", "target/*.jar"]
