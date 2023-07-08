package com.alexluki.loggerapi.dbmodels;

import com.alexluki.loggerapi.infrastructure.CustomLocalDateTimeDeserializer;
import com.alexluki.loggerapi.infrastructure.HibernateProxySerializer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@ToString
@Table(
        uniqueConstraints=
        @UniqueConstraint(columnNames={"imageId", "deviceId"})
)
public class DockerImageEntity {

    @Id
    @GeneratedValue
    private UUID id;

    @NotBlank
    @Column
    private String containers;

    @NotNull
    @Column
    @JsonDeserialize(using = CustomLocalDateTimeDeserializer.class)
    private LocalDateTime createdAt;

    @NotBlank
    @Column
    private String createdSince;

    @Column
    private String digest;

    @NotBlank
    @Column
    private String imageId;

    @NotBlank
    @Column
    private String repository;

    @Column
    private String sharedSize;

    @NotBlank
    @Column
    private String size;

    @NotBlank
    @Column
    private String tag;

    @Column
    private String uniqueSize;

    @NotBlank
    @Column
    private String virtualSize;

    @NotNull
    @Column(updatable = false)
    private LocalDateTime recordCreationDate;

    @Column
    private LocalDateTime removalDate;

    @Column(columnDefinition = "boolean default true")
    private Boolean isPresent;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "deviceId")
    @JsonIgnore
    private DeviceEntity deviceEntity;

    public DockerImageEntity() {
        this.recordCreationDate = LocalDateTime.now();
        this.isPresent = true;
    }
}
