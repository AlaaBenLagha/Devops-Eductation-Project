FROM alpine
RUN apk add openjdk11
EXPOSE 8084
CMD "java"
ADD target/achat-1.0.jar achat-1.0.jar
ENTRYPOINT ["java","-jar","/achat-1.0.jar"]