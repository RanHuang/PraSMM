1. 文本处理
1)正则匹配
2)截取文件某列(-f 指定列; -d 指定分割符)
    cut -f 2 -d " " filename
3)文本拼接
    paste file1 file2 -d “,”
4)管道重定向
  $ paste file1 file2 -d “ ” > file3
2. 将测试数据导入Redis中
$ cat citypos.txt | redis-cli -h 172.17.0.2 -p 6379 --pipe