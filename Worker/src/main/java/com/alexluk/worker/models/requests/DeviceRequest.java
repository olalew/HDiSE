package com.alexluk.worker.models.requests;

import lombok.*;

import java.time.LocalDateTime;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DeviceRequest {
    private Long id;
    private LocalDateTime createDate;
    @NotBlank
    @Pattern(regexp = "^([0-9A-Fa-f]{2}[:-]){5}([0-9A-Fa-f]{2})$")
    private String macAddress;
    @NotBlank
    private String computerName;
    @NotBlank
    private String distribution;
    @NotBlank
    private String osVersion;
    @NotBlank
    private String kernelVersion;
    @NotBlank
    private String systemArchitecture;
    @NotBlank
    @Pattern(regexp = "^((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$")
    private String ipAddress;
    @NotBlank
    private String cpuModel;
    @Positive
    private Integer cpuCores;
    @NotBlank
    private String cpuSpeed;
    @Positive
    private Long ramSize;
    @NotBlank
    private String ramType;
    @Positive
    private String storageSize;
    @NotBlank
    private String storageType;
    @NotBlank
    private String graphicsCardModel;
    @Positive
    private Long graphicsCardMemory;
    @NotBlank
    private String screenResolution;
    @NotBlank
    private String networkCardModel;
    @NotBlank
    private String soundCardModel;
    @NotBlank
    private String powerSupply;
    @NotBlank
    private String motherboardModel;
    @NotBlank
    private String biosVersion;
}