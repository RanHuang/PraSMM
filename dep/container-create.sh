#!/bin/bash

# mysql
MYSQL_NAME=ssm-mysql
docker run --name $MYSQL_NAME -p 3306:3306 -e MYSQL_ROOT_PASSWORD=123456 -d mysql:latest

# redis
REDIS_NAME=ssm-redis
docker run --name $REDIS_NAME -p 6379:6379 -v $(pwd)/redis/redis.conf:/etc/redis/redis.conf -v $(pwd)/redis/data:/data -d redis:latest redis-server /etc/redis/redis.conf --appendonly yes

# activemq
ACTIVEMQ_NAME=ssm-activemq
docker run -d --name $ACTIVEMQ_NAME -p 61616:61616 -p 8161:8161 webcenter/activemq

docker ps

function container_ip() {
    docker inspect --format '{{.Name}} -- {{ .NetworkSettings.IPAddress }}' $1
}

container_ip $MYSQL_NAME
container_ip $REDIS_NAME
container_ip $ACTIVEMQ_NAME
