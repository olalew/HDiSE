#!/bin/bash

json_data='{
    "name": "Some cool test name"
}'

java -jar /home/sudokit/Documents/College/Engineering/S6/HDiSE/HDiSE/Worker/worker.jar 0 "$json_data" >> log.txt