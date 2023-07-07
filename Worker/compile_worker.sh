#!/bin/bash
set -e

# Get the absolute path of the script directory
DIR="$(cd "$(dirname "$0")" && pwd)"
cd "$DIR"

# Clean the project and compile the code
mvn clean compile

# Create an executable JAR file with dependencies using the assembly plugin
mvn assembly:single # -DdescriptorId=jar-with-dependencies

# Copy the generated JAR file to the desired location
cp ./target/LogWorker-1.0-SNAPSHOT-jar-with-dependencies.jar "$DIR/worker.jar"
