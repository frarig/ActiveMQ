FROM openjdk:17-alpine
COPY build/libs/docker-test-0.0.1.jar docker-test-0.0.1.jar
ENTRYPOINT ["java","-jar","/ActiveMQ-1.0.jar"]