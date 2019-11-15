#!/bin/bash

MYSQL_NAME=ssm-mysql
REDIS_NAME=ssm-redis
ACTIVEMQ_NAME=ssm-activemq

docker start $MYSQL_NAME
docker start $REDIS_NAME
docker start $ACTIVEMQ_NAME

docker inspect --format '{{.Name}} -- {{ .NetworkSettings.IPAddress }}' $(docker ps -q)
