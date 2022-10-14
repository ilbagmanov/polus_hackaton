#!/bin/bash
# Deploy app

git pull
mvn clean install
# shellcheck disable=SC2046
kill $(lsof -t -i:8080)
mvn spring-boot:run > /dev/null 2>&1 &