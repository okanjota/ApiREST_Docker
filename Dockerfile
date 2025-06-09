FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /app 
COPY . . 
RUN mvn clean package -DskipTests

FROM openjdk:17-jdk-slim
WORKDIR /app
COPY - from=build /app/target/APIREST_Docker.jar /app/app.jar
EXPOSE 8080:8080
ENTRYPOINT [ "java", "-jar", "app.jar" ]