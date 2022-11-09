FROM alpine
RUN apk add openjdk11
EXPOSE 80
CMD "java"
ADD target/Devops-Eductation-Project.jar Devops-Eductation-Project.jar
ENTRYPOINT ["java","-jar","/Devops-Eductation-Project.jar"]