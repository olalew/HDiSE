#!/bin/bash

# File to save the timestamp
timestamp_file="last_run_timestamp.txt"

# Get the current timestamp
current_timestamp=$(date +"%Y-%m-%d %H:%M:%S")

# If the timestamp file exists, get the saved timestamp and use it to filter the logs
if [[ -f "$timestamp_file" ]]; then
    saved_timestamp=$(cat "$timestamp_file")
    output=$(journalctl --since "$saved_timestamp" -o json-pretty)
else
    # If the timestamp file doesn't exist, get the last 1000 records
    output=$(journalctl -n 1000 -o json-pretty)
fi

# Combine the JSON objects into a JSON list
output=$(echo "$output" | sed '$!s/}$/},/')
output="[$output]"

echo "$output"

# Save the current timestamp for the next run
echo "$current_timestamp" > "$timestamp_file"
