package com.alexluki.loggerapi.dbmodels;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "process_record")
public class ProcessRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String processUser;
    private Integer pid;
    private Double cpu;
    private Double mem;
    private String time;
    private String command;
}

