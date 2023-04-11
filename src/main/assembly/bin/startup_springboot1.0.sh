#!/bin/bash

serverName="springboot1.0"
export serverName

#LANG=zh.UTF-8
#export LANG

JAVA_HOME=/syiptv/IPTV/jdk1.8.0_211
export JAVA_HOME

echo $JAVA_HOME

for pid in `ps -ef | grep "${serverName}.jar" | grep -v "grep" | awk ' { print $2 } '`
do
echo $pid
kill -9 $pid;
echo serverName=$serverName pid=$pid;
done

sleep 1
cd /syiptv/IPTV/$serverName/
nohup $JAVA_HOME/bin/java -jar $serverName.jar >/dev/null 2>&1 &
