# syntax=docker/dockerfile:1

FROM openjdk:17

WORKDIR /app

COPY target/Sm_docker_app.jar .

EXPOSE 9799

ENTRYPOINT ["java","-jar","Sm_docker_app.jar"]
