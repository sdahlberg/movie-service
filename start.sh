#!/bin/sh
./wait-for-it.sh movie-postgres:5432 -t 15
java -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:5005 -Dspring.profiles.active=container -jar app.jar