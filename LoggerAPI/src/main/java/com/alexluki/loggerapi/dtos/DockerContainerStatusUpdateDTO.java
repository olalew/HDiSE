package com.alexluki.loggerapi.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DockerContainerStatusUpdateDTO {
    private String containerId;
    private String status;
}
