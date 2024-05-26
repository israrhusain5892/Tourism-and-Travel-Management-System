FROM maven:3.8.5-openjdk-17 AS builder


WORKDIR /app
COPY pom.xml .

# RUN mvn dependency:go-offline-build
COPY . .
# COPY ${JAR_FILE} app.jar
RUN mvn clean package -DskipTests
FROM openjdk:17.0.1-jdk-slim
WORKDIR /app
COPY --from=builder /app/target/Travel-and-Tourism-Management-System-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8081
ENTRYPOINT [ "java","-jar" ,"app.jar"]