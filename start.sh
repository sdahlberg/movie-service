#!/bin/sh
./wait-for-it.sh movie-postgres:5432 -t 15
java -Dspring.profiles.active=container -jar app.jar