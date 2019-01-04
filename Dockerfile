FROM openjdk:8-jdk-alpine
VOLUME /tmp
EXPOSE 8082
CMD java -XX:+PrintFlagsFinal -XX:+UnlockExperimentalVMOptions -XX:+UseCGroupMemoryLimitForHeap -XX:MaxRAMFraction=1 -Xmx1024M -jar java-container.jar
ADD target/movie-demo-0.0.1-SNAPSHOT.jar target/app.jar
RUN sh -c 'touch target/app.jar'
ENTRYPOINT ["java", "-Dspring.profiles.active=container", "-jar", "target/app.jar"]
