package com.alexluki.loggerapi.dbmodels;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import org.hibernate.annotations.CreationTimestamp;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
public class ProcessInfoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "device_id", nullable = false, referencedColumnName = "device_id")
    private DeviceEntity device;

    @NotBlank
    @Column(name = "process_user", nullable = false)
    private String user;

    @NotNull
    @PositiveOrZero
    @Column(name = "pid", nullable = false)
    private Integer pid;

    @NotBlank
    @Column(name = "cpu", nullable = false)
    private String cpu;

    @NotNull
    @PositiveOrZero
    @Column(name = "mem", nullable = false)
    private Integer mem;

    @NotBlank
    @Column(name = "time", nullable = false)
    private String time;

    @NotBlank
    @Column(name = "command", nullable = false)
    private String command;

    @CreationTimestamp
    @Column(name = "create_date", nullable = false, updatable = false)
    private LocalDateTime createDate;
}
