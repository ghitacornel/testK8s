# can use a custom JRE image
# check jlink
FROM openjdk:latest
LABEL desc=gctK8s
COPY /target/testK8s-1.0-spring-boot.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]