#!/bin/bash

MYSQL_NAME=ssm-mysql
REDIS_NAME=ssm-redis
ACTIVEMQ_NAME=ssm-activemq

docker stop $MYSQL_NAME
docker stop $REDIS_NAME
docker stop $ACTIVEMQ_NAME

docker ps

