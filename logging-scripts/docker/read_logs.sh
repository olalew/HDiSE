#!/bin/bash

# Define the path to the file storing the IDs of existing containers
existing_ids_file="existing_container_ids.txt"

# Define the path to the file storing the last recorded timestamp
last_timestamp_file="last_timestamp.txt"

# Check if the existing IDs file exists
if [[ ! -f "$existing_ids_file" ]]; then
    echo "Existing containers file not found. Please run the previous script first."
    exit 1
fi

# Read the existing container IDs from the file
existing_ids=()
while IFS= read -r id; do
    existing_ids+=("$id")
done < "$existing_ids_file"

# Declare an associative array to store the logs for each container
declare -A logs

# Check if the last timestamp file exists
if [[ -f "$last_timestamp_file" ]]; then
    # Read the last recorded timestamp
    last_timestamp=$(cat "$last_timestamp_file")
fi

# Iterate over the existing container IDs
for id in "${existing_ids[@]}"; do
    # Retrieve the last 1000 logs from the container if the timestamp is not available
    if [[ -z "$last_timestamp" ]]; then
        container_logs=$(sudo docker container logs --tail 1000 -t "$id" 2>/dev/null)
    else
        # Read all logs after the last recorded timestamp
        container_logs=$(sudo docker container logs --since "$last_timestamp" -t "$id" 2>/dev/null)
    fi

    # Store the logs for the container in the associative array
    logs["$id"]=$container_logs
done

# Update the last timestamp with the current timestamp
last_timestamp=$(date +%s)
echo "$last_timestamp" > "$last_timestamp_file"

# Output the logs for each container in JSON format
output="["
for id in "${!logs[@]}"; do
    logs_json=$(echo "${logs[$id]}" | sed -e 's/^/"/' -e 's/$/"/')
    output+="\n{\"container_id\":\"$id\",\"logs\":[$logs_json]},"
done
output="${output%?}"  # Remove the trailing comma
output+="\n]"

echo -e "$output"
