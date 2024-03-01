FROM openjdk:17
EXPOSE 9090
ADD target/firstjobimage.jar firstjobimage.jar
ENTRYPOINT ["java","-jar","/firstjobimage.jar"]

