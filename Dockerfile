FROM openjdk:17

COPY ./target/usuario-app-0.0.1-SNAPSHOT.jar usuario-app-0.0.1-SNAPSHOT.jar

CMD ["java","-jar","usuario-app-0.0.1-SNAPSHOT.jar"]