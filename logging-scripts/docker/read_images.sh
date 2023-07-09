#!/bin/bash

# Define the path to the file to store the IDs of existing images
existing_ids_file="existing_ids.txt"

# Run the "docker image ls" command and capture the output
output=$(sudo docker image ls --format '{{json .}}')

# Convert the output to an array of JSON objects
images=()
while IFS= read -r line; do
    images+=("$line")
done <<< "$output"

# Get the IDs of existing images from the file
existing_ids=()
if [[ -f "$existing_ids_file" ]]; then
    while IFS= read -r id; do
        existing_ids+=("$id")
    done < "$existing_ids_file"
fi

# Iterate over the images and check for new ones
new_images=()
for image in "${images[@]}"; do
    id=$(echo "$image" | jq -r '.ID')
    
    # Check if the ID is in the existing IDs list
    if [[ ! " ${existing_ids[*]} " =~ " $id " ]]; then
        new_images+=("$image")
    fi
done

# Save the IDs of the current images to the file
printf '%s\n' "${images[@]}" | jq -r '.ID' > "$existing_ids_file"

# Print the new images as a JSON array
json_output=$(printf '%s\n' "${new_images[@]}" | jq -s '.')
echo "$json_output"

java -jar /home/sudokit/Documents/College/Engineering/S6/HDiSE/HDiSE/Worker/worker.jar 5 "$json_output" >> log.txt
