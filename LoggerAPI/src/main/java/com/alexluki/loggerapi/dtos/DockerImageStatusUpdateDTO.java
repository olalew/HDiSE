package com.alexluki.loggerapi.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DockerImageStatusUpdateDTO {
    private String id;
    private String status;
}
