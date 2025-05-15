# can use a custom JRE image
# check jlink
FROM eclipse-temurin:21-jre
COPY target/testK8s-1.0-spring-boot.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]