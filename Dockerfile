FROM openjdk:17-jdk-alpine
WORKDIR /target
COPY target/proybase-0.0.1-SNAPSHOT.jar /app/proybase-springboot.jar
EXPOSE 8863
ENTRYPOINT ["java", "-jar", "/app/proybase-springboot.jar"]
