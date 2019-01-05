FROM adoptopenjdk/openjdk11:alpine-slim
VOLUME /tmp
EXPOSE 8082
# further reading about memory managemnet: https://medium.com/adorsys/jvm-memory-settings-in-a-container-environment-64b0840e1d9e
CMD java -version -XX:+PrintFlagsFinal -Xmx512M -jar java-container.jar
ADD target/movie-demo-0.0.1-SNAPSHOT.jar target/app.jar
RUN sh -c 'touch target/app.jar'
ENTRYPOINT ["java", "-Dspring.profiles.active=container", "-jar", "target/app.jar"]
