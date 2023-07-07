package com.alexluk.worker.models.entities;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProcessRecord {
    private String processUser;
    private String user;
    private Integer pid;
    private String cpu;
    private Double mem;
    private String time;
    private String command;
}