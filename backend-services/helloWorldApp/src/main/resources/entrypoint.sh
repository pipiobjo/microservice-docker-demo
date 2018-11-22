#!/bin/sh

JAR=$1
JAVA_OPTS=${JAVA_OPTS:="-Xmx256m"}
echo "JAVA_OPTS=$JAVA_OPTS"
exec java $JAVA_OPTS -jar $JAR