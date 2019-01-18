FROM adoptopenjdk/openjdk11:alpine-slim
VOLUME /tmp
EXPOSE 8080
RUN apk add --no-cache bash
# further reading about memory managemnet: https://medium.com/adorsys/jvm-memory-settings-in-a-container-environment-64b0840e1d9e
# CMD java -version -XX:+PrintFlagsFinal -Xmx512M -jar java-container.jar

COPY target/app.jar app.jar
COPY start.sh start.sh
RUN chmod +x start.sh
COPY wait-for-it.sh wait-for-it.sh
RUN chmod +x wait-for-it.sh

RUN sh -c 'touch app.jar'
ENTRYPOINT ["./start.sh"]
