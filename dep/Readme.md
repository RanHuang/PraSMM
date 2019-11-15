## 下载镜像
    ./images-pull.sh  
## 创建依赖服务容器
    ./container-stop.sh  
## 创建数据库
    $ docker exec -it ssm-mysql bash  
    /# mysql -uroot -p123456  
    mysql> create database if not exists ssm;   
    mysql> use ssm;   
## 初始化数据库
    create table  
    insert data  