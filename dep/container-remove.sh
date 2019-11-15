#!/bin/bash

MYSQL_NAME=ssm-mysql
REDIS_NAME=ssm-redis
ACTIVEMQ_NAME=ssm-activemq

docker rm $MYSQL_NAME
docker rm $REDIS_NAME
docker rm $ACTIVEMQ_NAME

