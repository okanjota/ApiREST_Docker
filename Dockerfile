# Etapa 1: Build (opcional, se você quiser compilar dentro do Docker)
# FROM maven:3.8.5-openjdk-17 AS build
# WORKDIR /app
# COPY . .
# RUN mvn clean package -DskipTests

# Etapa 2: Runtime
FROM openjdk:17-jdk-slim
VOLUME /tmp
WORKDIR /app


COPY target/api-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
