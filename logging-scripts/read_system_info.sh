#!/bin/bash

# Read information about our system
# 1. information about currently running processes

mapfile -t running_processes < <(ps -e -o user,pid,cpu,sz,time,command)

# Assuming you have already stored the output in the "lines" array

# Start the JSON array
json="["
count=0
# Iterate over each line
for line in "${running_processes[@]}"; do

    # Check if the string contains "chrome"
    if [[ $line == *chrome* ]]; then
        continue
    fi

    # Split the line into columns based on whitespace
    read -ra cols <<< "$line"
    count=$((count + 1))
    # Construct the JSON record manually
    json+=" {\"user\":\"${cols[0]}\", \"pid\":\"${cols[1]}\", \"cpu\":\"${cols[2]}\", \"mem\":\"${cols[3]}\", \"time\":\"${cols[4]}\", \"command\":\"${cols[5]}\"},"
done
# Remove the trailing comma and close the JSON array
json="${json%,}]"
# Print the final JSON
echo "$json"


# Execute Java code with a parameter
java -jar /home/sudokit/Documents/College/Engineering/S6/HDiSE/HDiSE/worker.jar 0 "$json"
