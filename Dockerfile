FROM openjdk:18-jdk-alpine
COPY ./target/Cinema_Gestion-0.0.1-SNAPSHOT.jar myapp.jar
EXPOSE 8010
ENTRYPOINT ["java", "-jar", "myapp.jar"]