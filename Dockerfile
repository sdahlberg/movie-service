FROM adoptopenjdk/openjdk11:alpine-slim
VOLUME /tmp
EXPOSE 8082
RUN apk add --no-cache bash
# further reading about memory managemnet: https://medium.com/adorsys/jvm-memory-settings-in-a-container-environment-64b0840e1d9e
CMD java -version -XX:+PrintFlagsFinal -Xmx512M -jar java-container.jar
COPY target/movie-demo-0.0.1-SNAPSHOT.jar app.jar
COPY start.sh start.sh
COPY wait-for-it.sh wait-for-it.sh
RUN sh -c 'touch app.jar'
ENTRYPOINT ["./start.sh"]
