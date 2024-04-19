FROM openjdk:17-alpine
WORKDIR /home/myapp
COPY /target/employee-demo-0.0.1-SNAPSHOT.jar /home/myapp/employee-demo-0.0.1-SNAPSHOT.jar
EXPOSE 8080
CMD ["java", "-jar", "/employee-demo-0.0.1-SNAPSHOT.jar"]