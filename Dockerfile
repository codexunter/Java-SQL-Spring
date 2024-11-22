FROM openjdk:21-jdk
COPY target/apiSpringMaven-0.0.1-SNAPSHOT.jar api-maven.jar
ENTRYPOINT ["java","-jar","/api-maven.jar"]