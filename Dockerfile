FROM alpine
RUN apk add openjdk11
RUN apk --no-cache add curl
RUN curl -u admin:admin -o achat.jar "http://192.168.1.16:8081/repository/maven-releases/tn/esprit/rh/achat/1.0/achat-1.0.jar" -L
EXPOSE 8084
CMD "java"
ADD target/achat-1.0.jar achat-1.0.jar
ENTRYPOINT ["java","-jar","/achat-1.0.jar"]