#!/usr/bin/env bash

PROJECT_ROOT="/var/www/deploy"

DEPLOY_LOG="$PROJECT_ROOT/deploy.log"

TIME_NOW=$(date +%c)

# jar 찾기
JAR_FILE=$(ls -tr $PROJECT_ROOT/ | grep jar | tail -n 1)
echo "JAR Name: $JAR_FILE" >> $DEPLOY_LOG

# 현재 구동 중인 애플리케이션 pid 확인
CURRENT_PID=$(pgrep -f $PROJECT_ROOT/$JAR_FILE)

# 프로세스가 켜져 있으면 종료
if [ -z $CURRENT_PID ]; then
  echo "$TIME_NOW > 현재 실행중인 애플리케이션이 없습니다" >> $DEPLOY_LOG
else
  echo "$TIME_NOW > 실행중인 $CURRENT_PID 애플리케이션 종료 " >> $DEPLOY_LOG
  kill -9 $CURRENT_PID
fi
