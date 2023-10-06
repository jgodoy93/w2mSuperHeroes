FROM openjdk:17-jdk-slim
ARG JAR_FILE=target/*.jar
COPY ./target/w2msuperheroes-2.0.0.jar app.jar
ENTRYPOINT ["java", "-jar","/app.jar"]
