package com.alexluki.loggerapi.dbmodels;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "process_record")
public class ProcessRecordEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "device_id", nullable = false)
    private DeviceEntity device;

    @Column(nullable = false)
    private String processUser;

    @Column(nullable = false)
    private Integer pid;

    @Column(nullable = false)
    private String cpu;

    @Column(nullable = false)
    private Double mem;

    @Column(nullable = false)
    private String time;

    @Column(nullable = false)
    private String command;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime timestamp;
}
