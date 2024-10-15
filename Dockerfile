FROM openjdk:17-jdk-alpine


RUN apk add --no-cache maven

WORKDIR /app

COPY pom.xml ./


RUN mvn dependency:go-offline

COPY src ./src


RUN mvn clean package


COPY target/*.jar app.jar


EXPOSE 8080


ENTRYPOINT ["java", "-jar", "/app/app.jar"]
