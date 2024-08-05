FROM maven:latest
WORKDIR /authentication-server

COPY . /authentication-server
COPY . /src/main/resources/application.yaml
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "/authentication-server/target/authentication-server-0.0.1-SNAPSHOT.jar"]