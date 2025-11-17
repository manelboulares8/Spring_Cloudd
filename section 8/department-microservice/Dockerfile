#FROM openjdk:21
FROM eclipse-temurin:21-jdk

#Information around who maintains the image
LABEL "org.opencontainers.image.authors"="manel.com"
# Add the application's jar to the image
COPY target/department-microservice-0.0.1-SNAPSHOT.jar department-microservice-0.0.1-SNAPSHOT.jar
# execute the application
ENTRYPOINT ["java", "-jar", "department-microservice-0.0.1-SNAPSHOT.jar"]