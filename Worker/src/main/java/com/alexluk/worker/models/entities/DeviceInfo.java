package com.alexluk.worker.models.entities;

import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DeviceInfo {
    private int id;
    private UUID deviceId;
    private String createDate;
    private String macAddress;
    private String computerName;
    private String distribution;
    private String osVersion;
    private String kernelVersion;
    private String systemArchitecture;
    private String ipAddress;
    private String cpuModel;
    private String cpuCores;
    private String cpuSpeed;
    private String ramSize;
    private String ramType;
    private String storageSize;
    private String storageType;
    private String graphicsCardModel;
    private String graphicsCardMemory;
    private String screenResolution;
    private String networkCardModel;
    private String soundCardModel;
    private String powerSupply;
    private String motherboardModel;
    private String biosVersion;

    public LocalDateTime getCreateDate() {
        return LocalDateTime.parse(createDate);
    }
}
