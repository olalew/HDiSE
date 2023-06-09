#!/bin/bash
DIR="$(cd "$(dirname "$0")" && pwd)"
cd $DIR

cd ..
mvn clean compile assembly:single

cp ./target/LogWorker-1.0-SNAPSHOT-jar-with-dependencies.jar ./worker.jar


