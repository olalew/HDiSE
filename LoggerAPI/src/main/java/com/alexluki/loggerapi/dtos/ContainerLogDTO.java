package com.alexluki.loggerapi.dtos;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ContainerLogDTO {
    private String containerId;
    private List<String> logs;
}

