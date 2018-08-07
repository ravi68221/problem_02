FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG JAR_FILE
EXPOSE 8080
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
# docker build -t weatherapp --build-arg JAR_FILE=<path-to-jar> .
