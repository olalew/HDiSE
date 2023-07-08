package com.alexluki.loggerapi.dbmodels;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "docker_container_entity")
public class DockerContainerEntity {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "container_id")
    private String containerId;

    @Column(name = "image")
    private String image;

    @Column(name = "name")
    private String name;

    @Column(name = "status")
    private String status;

    @Column(name = "ports")
    private String ports;

    @Column(name = "is_present", nullable = false)
    private boolean isPresent = true;

    @Column(name = "removal_date")
    private LocalDateTime removalDate;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "device_id")
    @JsonIgnore
    private DeviceEntity deviceEntity;

    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt;
}

