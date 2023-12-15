FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
COPY run.sh .
COPY ./jar-src/*.jar app.jar
ENTRYPOINT ["./run.sh"]
