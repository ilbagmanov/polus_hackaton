#!/bin/bash
# Deploy app

git pull
kill $(lsof -t -i:8080)
nohup mvn clean install spring-boot:run &
sleep 3
echo "After a few second server will run"
echo "Please, press ENTER to continue"
