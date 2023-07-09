#!/bin/bash

# Get computer name
computerName=$(hostname)

# Get MAC address of the first network interface
macAddress=$(cat /sys/class/net/$(ip route show default | awk '/default/ {print $5}')/address)

# Get distribution name
distribution=$(lsb_release -ds | sed 's/\"//g')

# Get OS version
osVersion=$(lsb_release -rs)

# Get kernel version
kernelVersion=$(uname -r)

# Get system architecture
systemArchitecture=$(uname -m)

# Get IP address
ipAddress=$(hostname -I | awk '{print $1}')

# Get system information
cpuModel=$(lscpu | grep "Model name:" | cut -d ":" -f 2 | xargs)
cpuCores=$(nproc)
cpuSpeed=$(lscpu | grep "CPU MHz:" | cut -d ":" -f 2 | xargs)
ramSize=$(free -m | awk '/^Mem:/{print $2}')
ramType=$(sudo dmidecode --type memory | grep "Type:" | head -1 | cut -d ":" -f 2 | xargs)
storageSize=$(df -h --total | grep 'total' | awk '{print $2}')
storageType=$(lsblk -d -o name,rota | grep 'sd' | awk '{if ($2 == 0) print "SSD"; else print "HDD"}')
graphicsCardModel=$(lspci | grep VGA | cut -d ":" -f 3 | xargs)

screenResolution="" # $(xdpyinfo | grep 'dimensions:'| awk '{print $2}')
networkCardModel=$(lspci | grep Network | cut -d ":" -f 3 | xargs)
soundCardModel=$(lspci | grep Audio | cut -d ":" -f 3 | xargs)
powerSupply="Unknown" # This information is typically not available without additional tools
motherboardModel=$(sudo dmidecode -t baseboard | grep "Product Name:" | cut -d ":" -f 2 | xargs)
biosVersion=$(sudo dmidecode -t bios | grep "Version:" | cut -d ":" -f 2 | xargs)

# Create JSON
json=$(cat <<EOF
{
  "computerName": "$computerName",
  "macAddress": "$macAddress",
  "distribution": "$distribution",
  "osVersion": "$osVersion",
  "kernelVersion": "$kernelVersion",
  "systemArchitecture": "$systemArchitecture",
  "ipAddress": "$ipAddress",
  "cpuModel": "$cpuModel",
  "cpuCores": "$cpuCores",
  "cpuSpeed": "$cpuSpeed",
  "ramSize": "$ramSize",
  "ramType": "$ramType",
  "storageSize": "$storageSize",
  "storageType": "$storageType",
  "graphicsCardModel": "$graphicsCardModel",
  "screenResolution": "$screenResolution",
  "networkCardModel": "$networkCardModel",
  "soundCardModel": "$soundCardModel",
  "powerSupply": "$powerSupply",
  "motherboardModel": "$motherboardModel",
  "biosVersion": "$biosVersion"
}
EOF
)

# Print JSON
echo "$json"

java -jar /home/sudokit/Documents/College/Engineering/S6/HDiSE/HDiSE/Worker/worker.jar 1 "$json" >> log.txt
