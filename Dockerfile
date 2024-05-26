FROM maven:3.8.5-openjdk-17 AS build


WORKDIR /app
COPY ${JAR_FILE} app.jar
# RUN mvn clean package -DskipTests
# FROM openjdk:17.0.1-jdk-slim
# COPY --from=build /target/Travel-and-Tourism-Management-System-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8081
ENTRYPOINT [ "java","-jar" ,"Travel-and-Tourism-Management-System-0.0.1-SNAPSHOT.jar"]