FROM openjdk:11
VOLUME /tmp
ADD ./target/user-ms-0.0.1-SNAPSHOT.jar user-ms.jar
ENTRYPOINT ["java","-jar","/user-ms.jar"]