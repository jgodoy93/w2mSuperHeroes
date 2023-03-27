FROM openjdk:11.0.9-jre-slim
ARG JAR_FILE=target/*.jar
COPY ./target/w2msuperheroes-1.0.0.jar app.jar
ENTRYPOINT ["java", "-jar","/app.jar"]
