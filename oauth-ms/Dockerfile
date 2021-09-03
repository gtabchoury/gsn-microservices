FROM openjdk:11
VOLUME /tmp
ADD ./target/oauth-ms-0.0.1-SNAPSHOT.jar oauth-ms.jar
ENTRYPOINT ["java","-jar","/oauth-ms.jar"]