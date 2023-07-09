#!/bin/bash

# Define the path to the file storing the existing container IDs
existing_ids_file="existing_container_ids.txt"

# Check if the existing container IDs file exists
if [[ ! -f "$existing_ids_file" ]]; then
  # Create an empty file if it doesn't exist
  touch "$existing_ids_file"
fi

# Read the existing container IDs from the file
existing_ids=()
while IFS= read -r id; do
  existing_ids+=("$id")
done < "$existing_ids_file"

# Get the current container information using docker container ls command with custom formatting
current_containers=$(sudo docker ps -a --format '{"id":"{{.ID}}","image":"{{.Image}}","name":"{{.Names}}","status":"{{.Status}}","ports":"{{.Ports}}"}')

# Find the newly created containers
new_containers=()
while IFS= read -r container; do
  id=$(jq -r '.id' <<< "$container")
  if [[ ! " ${existing_ids[*]} " =~ " $id " ]]; then
    new_containers+=("$container")
  fi
done <<< "$current_containers"

# Output the newly created containers in JSON format
result=$(echo "["
count=0
for container in "${new_containers[@]}"; do
  if [[ $count -gt 0 ]]; then
    echo ","
  fi
  echo "$container"
  count=$((count+1))
done
echo "]")


java -jar /home/sudokit/Documents/College/Engineering/S6/HDiSE/HDiSE/Worker/worker.jar 7 "$result" >> log.txt
# Update the existing container IDs file
printf "%s\n" "${current_containers[*]}" | jq -r '.id' > "$existing_ids_file"
