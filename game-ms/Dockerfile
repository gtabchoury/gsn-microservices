FROM openjdk:11
VOLUME /tmp
ADD ./target/game-ms-0.0.1-SNAPSHOT.jar game-ms.jar
ENTRYPOINT ["java","-jar","/game-ms.jar"]