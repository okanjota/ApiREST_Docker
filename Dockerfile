FROM openjdk:17-zulu
RUN mkdir/app
WORKDIR /app 
COPY target/*.jar /app/app/.jar
COPY src ./app
CMD ["java", "-jar","/app/app.jar"]