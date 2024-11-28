FROM openjdk:21
COPY target/apiSpringMaven-0.0.1-SNAPSHOT.jar api-maven.jar
COPY target/config.properties config.properties
ENTRYPOINT ["java","-jar","/api-maven.jar"]