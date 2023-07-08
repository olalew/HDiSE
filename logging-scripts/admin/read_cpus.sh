#!/bin/bash

# Create an associative array
declare -A cpu_info

# Read the output line by line
while IFS=":" read -r key value
do
    # Trim leading whitespace from the value
    value=${value## }

    # Add the key-value pair to the array, unless the key is "Flags"
    if [[ $key != "Flags" ]]; then
        cpu_info["$key"]="$value"
    fi
done < <(lscpu)

# Convert the array to a JSON object and save it to a variable
json_output=$(
for key in "${!cpu_info[@]}"; do
    echo "\"$key\": \"${cpu_info[$key]}\","
done | sed '$ s/,$//' | awk 'BEGIN{print "{"}{print}END{print "}"}'
)

# Print the variable
echo "$json_output"
