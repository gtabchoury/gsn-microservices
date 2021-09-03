FROM openjdk:11
VOLUME /tmp
ADD ./target/group-ms-0.0.1-SNAPSHOT.jar group-ms.jar
ENTRYPOINT ["java","-jar","/group-ms.jar"]