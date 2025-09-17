# Stage 1: Build project with Maven inside Docker
FROM maven:3.9.6-eclipse-temurin-17 AS builder
WORKDIR /build

# Copy pom files first (better build caching)
COPY pom.xml .
COPY app/pom.xml app/
COPY user/pom.xml user/

# Download dependencies (so they're cached unless pom changes)
RUN mvn dependency:go-offline -B

# Copy full source code
COPY . .

# Package the app module (will also build user)
RUN mvn clean package -DskipTests -pl app -am

# Stage 2: Run with lightweight JDK
FROM eclipse-temurin:17-jre
WORKDIR /app

# Copy final JAR from builder
COPY --from=builder /build/app/target/*.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]
