FROM openjdk:8-jdk-alpine
VOLUME /tmp
CMD java -XX:+PrintFlagsFinal -XX:+UnlockExperimentalVMOptions -XX:+UseCGroupMemoryLimitForHeap -jar java-container.jar
ADD target/movie-demo-0.0.1-SNAPSHOT.jar target/app.jar
ENTRYPOINT ["java", "-jar", "target/app.jar"]