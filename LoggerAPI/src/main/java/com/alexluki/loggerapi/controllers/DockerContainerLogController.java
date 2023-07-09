package com.alexluki.loggerapi.controllers;

import com.alexluki.loggerapi.dtos.ContainerLogDTO;
import com.alexluki.loggerapi.services.ContainerLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/containerLogs")
public class DockerContainerLogController {

    private final ContainerLogService containerLogService;

    @Autowired
    public DockerContainerLogController(ContainerLogService containerLogService) {
        this.containerLogService = containerLogService;
    }

    @PostMapping("/{deviceId}")
    public ResponseEntity<?> saveContainerLogs(@PathVariable UUID deviceId,
                                               @RequestBody List<ContainerLogDTO> containerLogDTOs) {
        try {
            containerLogService.saveContainerLogs(containerLogDTOs, deviceId);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
