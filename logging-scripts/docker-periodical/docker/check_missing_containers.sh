#!/bin/bash

# Define the path to the file storing the IDs of existing containers
existing_ids_file="existing_container_ids.txt"

# Check if the existing IDs file exists
if [[ ! -f "$existing_ids_file" ]]; then
    echo "Existing containers file not found. Please run the previous script first."
    exit 1
fi

# Read the existing IDs from the file
existing_ids=()
while IFS= read -r id; do
    existing_ids+=("$id")
done < "$existing_ids_file"

# Get the current IDs of Docker containers
current_ids=($(sudo docker ps -a -aq))

# Find the disappeared containers
disappeared_containers=()
for id in "${existing_ids[@]}"; do
    if [[ ! " ${current_ids[*]} " =~ " $id " ]]; then
        disappeared_containers+=("{\"id\":\"$id\",\"status\":\"gone\"}")
    fi
done

# Create the JSON output
output="["
if [[ ${#disappeared_containers[@]} -gt 0 ]]; then
    for ((i=0; i<${#disappeared_containers[@]}-1; i++)); do
        output+="\"${disappeared_containers[$i]}\","
    done
    output+="\"${disappeared_containers[-1]}\""
fi
output+="]"

# Output the JSON
echo "$output"

java -jar /home/sudokit/Documents/College/Engineering/S6/HDiSE/HDiSE/Worker/worker.jar 8 "$output" >> log.txt

# Update the existing containers file with the current IDs
printf "%s\n" "${current_ids[@]}" > "$existing_ids_file"
