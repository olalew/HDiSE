#!/bin/bash

# Read information about our system
# 1. Information about currently running processes

mapfile -t running_processes < <(ps -e -o user,pid,cpu,sz,time,command)

# Start the JSON array
json="["
count=0

# Iterate over each line
for line in "${running_processes[@]}"; do

    if [[ $count -gt 5 ]]; then
        break
    fi

    # Check if the string contains "chrome"
    if [[ $line == *chrome* ]]; then
        continue
    fi

    # Split the line into columns based on whitespace
    read -ra cols <<< "$line"
    
    # Check if the "pid" value is "PID"
    if [[ ${cols[1]} == "PID" ]]; then
        continue
    fi

    count=$((count + 1))

    # Construct the JSON record manually
    json+=" {\"user\":\"${cols[0]}\", \"pid\":\"${cols[1]}\", \"cpu\":\"${cols[2]}\", \"mem\":\"${cols[3]}\", \"time\":\"${cols[4]}\", \"command\":\"${cols[5]}\"},"
done

# Remove the trailing comma and close the JSON array
json="${json%,}]"


# Execute Java code with a parameter
java -jar /home/sudokit/Documents/College/Engineering/S6/HDiSE/HDiSE/Worker/worker.jar 0 "$json" >> log.txt
