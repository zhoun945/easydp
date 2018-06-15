#!/bin/sh
this_dir="$( cd "$( dirname "$0"  )" && pwd )"
parent_dir=`dirname "${this_dir}"`
pid_path="${parent_dir}/bin/project.pid"
echo $pid_path
PID=$(cat ${pid_path})
kill -9 $PID
