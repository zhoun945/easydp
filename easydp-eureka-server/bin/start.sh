#!/bin/sh
#启动参数
JAVA_OPTS="-server -Xms512m -Xmx512m -Xmn256m -XX:MetaspaceSize=64m -XX:MaxMetaspaceSize=64m -Xverify:none -XX:+DisableExplicitGC -Djava.awt.headless=true -Duser.timezone=GMT+08"
jar_name=easydp-eureka-server.jar

this_dir="$( cd "$( dirname "$0"  )" && pwd )"
parent_dir=`dirname "${this_dir}"`
log_dir="${parent_dir}/logs"
log_file="${log_dir}/catalina.out"
jar_file="${parent_dir}/${jar_name}"
#日志文件夹不存在，则创建
if [ ! -d "${log_dir}" ]; then
    mkdir "${log_dir}"
fi
#父目录下jar文件存在
if [ -f "${jar_file}" ]; then
    #启动jar包；重定向标准错误输出到文件，丢掉标准输出
    java $JAVA_OPTS -jar ${jar_file} 1>/dev/null 2>"${log_file}" &
    echo $! > ${parent_dir}/bin/project.pid
    exit 0
else
    echo -e "\033[31m${jar_file}文件不存在！\033[0m"
    exit 1
fi
