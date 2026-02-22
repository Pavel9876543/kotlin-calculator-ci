#!/usr/bin/env sh
set -e

BASEDIR=$(cd "$(dirname "$0")"; pwd)

exec "$BASEDIR/gradle/wrapper/gradle-wrapper.jar" "$@"
