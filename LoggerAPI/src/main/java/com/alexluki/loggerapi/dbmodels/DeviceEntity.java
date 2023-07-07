package com.alexluki.loggerapi.dbmodels;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "device_entity")
public class DeviceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "device_id", updatable = false, nullable = false, unique = true)
    private UUID deviceId;

    @PrePersist
    public void prePersist() {
        if (deviceId == null) {
            deviceId = UUID.randomUUID();
        }
    }

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime createDate;

    @NotBlank
    @Pattern(regexp = "^([0-9A-Fa-f]{2}[:-]){5}([0-9A-Fa-f]{2})$")
    @Column(nullable = false)
    private String macAddress;

    @NotBlank
    @Column(nullable = false)
    private String computerName;

    @NotBlank
    @Column(nullable = false)
    private String distribution;

    @NotBlank
    @Column(nullable = false)
    private String osVersion;

    @NotBlank
    @Column(nullable = false)
    private String kernelVersion;

    @NotBlank
    @Column
    private String systemArchitecture;

    @NotBlank
    @Pattern(regexp = "^((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$")
    @Column
    private String ipAddress;

    @NotBlank
    @Column
    private String cpuModel;

    @Column
    private String cpuCores;

    @Column
    private String cpuSpeed;

    @Column
    private String ramSize;

    @NotBlank
    @Column
    private String ramType;

    @Column
    private String storageSize;

    @Column
    private String storageType;

    @NotBlank
    @Column
    private String graphicsCardModel;

    @Positive
    @Column
    private Long graphicsCardMemory;

    @Column
    private String screenResolution;

    @NotBlank
    @Column
    private String networkCardModel;

    @NotBlank
    @Column
    private String soundCardModel;

    @NotBlank
    @Column
    private String powerSupply;

    @NotBlank
    @Column
    private String motherboardModel;

    @NotBlank
    @Column
    private String biosVersion;
}
