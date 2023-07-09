#!/bin/bash

# Define the path to the file storing the IDs of existing images
existing_ids_file="existing_ids.txt"

# Check if the existing IDs file exists
if [[ ! -f "$existing_ids_file" ]]; then
    echo "Existing IDs file not found. Please run the previous script first."
    exit 1
fi

# Read the existing IDs from the file
existing_ids=()
while IFS= read -r id; do
    existing_ids+=("$id")
done < "$existing_ids_file"

# Get the current IDs of Docker images
current_ids=($(sudo docker image ls --format '{{.ID}}'))

# Find the disappeared images
disappeared_images=()
for id in "${existing_ids[@]}"; do
    if [[ ! " ${current_ids[*]} " =~ " $id " ]]; then
        disappeared_images+=("{\"id\":\"$id\",\"status\":\"gone\"}")
    fi
done

# Output the disappeared images in JSON format
result=$(
    echo "["
    if [[ ${#disappeared_images[@]} -gt 0 ]]; then
        for ((i=0; i<${#disappeared_images[@]}-1; i++)); do
            echo "${disappeared_images[$i]},"
        done
        echo "${disappeared_images[-1]}"
    fi
    echo "]"
)


java -jar /home/sudokit/Documents/College/Engineering/S6/HDiSE/HDiSE/Worker/worker.jar 6 "$result" >> log.txt

# Update the existing IDs file with the current IDs
echo "${current_ids[@]}" > "$existing_ids_file"