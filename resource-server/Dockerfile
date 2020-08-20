FROM openjdk:8-jdk-alpine

RUN mkdir /code
COPY build/libs /code
EXPOSE 8080
ENTRYPOINT [ "sh", "-c", "java -jar -Duser.timezone=$TIMEZONE -Xms256m -Xmx2048m -XX:PermSize=2048m -XX:MaxPermSize=2048m -Xss1m  /code/*.jar" ]