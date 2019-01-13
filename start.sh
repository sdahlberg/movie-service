#!/bin/sh
./wait-for-it.sh db:5432 -t 15
java -Dspring.profiles.active=container -jar app.jar