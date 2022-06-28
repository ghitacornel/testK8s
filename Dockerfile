FROM openjdk:latest
COPY target/testK8s-1.0-SNAPSHOT-spring-boot.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]